(function () {
    console.log("js start");

    var pointNum = 180;
    var PARTICLE_RUNNING_MAX_SPEED = 0.5;

    var POINT_COLOR = '#cccccc';
    var POINT_RADIUS = 1.3;
    var POINT_LINE_MAX_LENGTH = 100;
    var POINT_LINE_ALPHA_OFFSET = 0;
    var POINT_LINE_ALPHA_MAX = 0.5;
    var POINT_LINE_WIDTH = 0.5;

    var eleWidth = document.documentElement.clientWidth;
    var eleHeight = document.documentElement.clientHeight;

    var points = new Array();

    console.log('width : ' + eleWidth);
    console.log('height : ' + eleHeight);

    function ParticlePoint(x, y, radius, color, runningAngle, runningSpeed) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.color = color;
        this.runningAngle = runningAngle;
        this.runningSpeed = runningSpeed;
    }

    function addCanvasToBody() {
        var view = document.body;
        var c = document.createElement('canvas');
        view.appendChild(c);

        c.style.position = "fixed";
        c.width = eleWidth;
        c.height = eleHeight;
        c.style.top = '0px';
        c.style.left = '0px';
        c.style.zIndex = '-5';
        c.style.backgroundColor = '#1a222c';

        return c;
    }

    function getRandomPoint() {
        var x = Math.random() * eleWidth;
        var y = Math.random() * eleHeight;
        var runningAngle = Math.random() * 360;
        var runningSpeed = Math.random() * PARTICLE_RUNNING_MAX_SPEED;
        var color = POINT_COLOR;
        var radius = Math.ceil(Math.random() * POINT_RADIUS + 1);

        if(x - radius < 0) {
            x = radius;
        }else if(x + radius > eleWidth){
            x = eleWidth - radius;
        }

        if(y - radius < 0){
            y = radius;
        }else if(y + radius > eleHeight){
            y = eleHeight - radius;
        }
        return new ParticlePoint(x, y, radius, color, runningAngle, runningSpeed);
    }

    function initPoint() {
        for (var i = 0; i < pointNum; i++){
            points.push(getRandomPoint());
        }
    }

    function toRadian(angle) {
        return angle / 180 * Math.PI;
    }

    function getDistance(x1, y1, x2, y2){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    function doParticleRun(point) {
        var nextX = Math.cos(toRadian(point.runningAngle)) * point.runningSpeed;
        var nextY = Math.sin(toRadian(point.runningAngle)) * point.runningSpeed;
        point.x += nextX;
        point.y -= nextY;

        //TODO 反射角度计算
        if(point.x <= 0){
            point.runningAngle = 180 - point.runningAngle;
        } else if(point.x >= eleWidth){
            point.runningAngle = 180 - point.runningAngle;
        }else if(point.y <= 0){
            point.runningAngle = 360 - point.runningAngle;
        }else if(point.y >= eleHeight){
            point.runningAngle = 360 - point.runningAngle;
        }
    }

    function paintThread(ctx){
        ctx.fillStylel = "#0000";
        ctx.clearRect(0, 0, eleWidth, eleHeight);
        for (var i = 0; i < points.length; i++){
            var point = points[i];
            ctx.beginPath();
            ctx.arc(point.x , point.y, point.radius, 0, 360, false);
            ctx.fillStyle = point.color;
            ctx.fill();
            ctx.closePath();

            doParticleRun(point);

            for (var j = 0; j < points.length; j++){
                if(i == j) continue;

                var p = points[j];
                var distance = getDistance(p.x, p.y, point.x, point.y);
                if(distance <= POINT_LINE_MAX_LENGTH){
                    var alpha = 1 - (distance / POINT_LINE_MAX_LENGTH);
                    alpha += POINT_LINE_ALPHA_OFFSET;
                    alpha /= 2;
                    alpha = alpha >= POINT_LINE_ALPHA_MAX ? POINT_LINE_ALPHA_MAX : alpha;
                    ctx.strokeStyle = "rgba(255,255,255," + alpha + ")";
                    ctx.lineWidth = POINT_LINE_WIDTH;
                    ctx.moveTo(p.x, p.y);
                    ctx.lineTo(point.x, point.y);
                    ctx.stroke();
                }
            }
        }
        console.log('paint thread')
    }

    function startPaintThread(ctx, fps){
        setInterval(paintThread, fps, ctx);
    }

    var c = addCanvasToBody();
    var ctx = c.getContext('2d');
    initPoint();
    startPaintThread(ctx, 30);

})();