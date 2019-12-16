// DOM 加载完再执行
$(function () {

    $(document).on('click', '#message-size-btn', function () {
        $.ajax({
            url: "/messages/recentNotRead",
            type: "get",
            dataType: 'json',
            success: function (data) {
                console.log(data.body);
                var content = '<ul class="menu">';
                var count = 0;
                $.each(data.body, function (i, item) {
                    content +=
                        '<li>' +
                        '<a href="' + '/manage/messages?uid=' + item.uid + '" target="_blank">' +
                        '<div class="pull-left">' +
                        '<img class="img-circle" src="' + item.avatar + '" alt="头像">' +
                        '</div>' +
                        '<h4>' + item.name +
                        '<small><span class="text-maroon">' + item.count + '条未读</span> <i class="fa fa-clock-o"></i> ' + item.createTime + '</small>' +
                        '</h4>' +
                        '<p class="nowrap">' + item.content + '</p>' +
                        '</a>' +
                        '</li>';
                    count += item.count;
                });
                content += '</ul>';
                $("#not-read-message-list").html(content);
            },
            error: function () {
            }
        });
    });

    $(document).on('click', '#notice-size-btn', function () {
        $.ajax({
            url: "/notice/recentNotRead",
            type: "get",
            dataType: 'json',
            success: function (data) {
                var content = '<ul class="menu">';
                var count = 0;
                $.each(data.body, function (i, item) {
                    content +=
                        '<li>' +
                        '<a href="/manage/notices" target="_blank">' +
                        '<i class="' + item.style + '"></i>' +
                        item.count + " 条" + item.content +
                        '</a>' +
                        '</li>';
                    count += item.count;
                });
                content += '</ul>';
                $("#not-read-notice-list").html(content);
                $(".notice-size").html(count);

            },
            error: function () {
            }
        })
    });

    //登录提交
    $(document).on("click", "#login_btn", function () {
        var param={
            username:$("#username").val(),
            password:$("#password").val()
        };

        $.ajax({
            url: "/login",
            type: 'POST',
            contentType:"application/json",
            data: JSON.stringify(param),
            success: function (data) {
                if(typeof (data["msg"])=="string"){
                    $("#message").html(data["msg"]);
                }
                else{
                    var content = '<ul class="nav navbar-nav" id="user-nav">'+
                            '<li class="dropdown user user-menu" id="user-menu">'+
                            '<a href="/manage/accoount/avatar" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">'+
                            '<img src="../images/logn.png" width="25" height="25" class="user-image">'+
                            '<span class="hidden-xs">'+data["msg"].username+'</span>' +'</a>'+
                            '<ul class="dropdown-menu">'+
                            '<li class="user-header">'+
                            '<img src="../images/logn.png" width="90" height="90" class="user-image" alt="" onclick="window.location.href=\'/manage/account/avatar\'">'+
                            '<p>'+
                            '<span>'+data["msg"].username+'</span>'+
                            '<small>'+data["msg"].email+'</small>'+
                            '</p>'+
                            '</li>'+
                            '<li class="user-body">'+
                            '<div class="row">'+
                            '<div class="col-xs-4 text-center">'+
                            '<a href="/manage/articles">'+"文章"+'</a>'+
                            '</div>'+
                            '<div class="col-xs-4 text-center">'+
                            '<a href="/manage/questions">'+"问答"+'</a>'+
                            '</div>'+
                            '<div class="col-xs-4 text-center">'+
                            '<a href="/iring">'+"我的主页"+'</a>'+
                            '</div>'+
                            '</div>'+
                            '</li>'+
                            '<li class="user-footer">'+
                            '<div class="pull-left">'+
                            '<a href="/manage/account" class="btn btn-default btn-flat">'+'个人中心'+'</a>'+
                            '</div>'+
                            '<div class="pull-right">'+
                            '<a href="/logout" class="btn btn-default btn-flat">'+'退出'+'</a>'+
                            '</div>'+
                            '</li>'+
                            '</ul>'+
                            '</li>'+ '</ul>';
                }$("#user-nav-wrapper").html(content);
                $("#login").modal("hide")

            }
        });
        return false;
    });

    // 加载推荐文章
    $(document).ready(function () {
        $.ajax({
            url: "/articles",
            type: 'GET',
            dataType:"json",
            success: function (msg) {
                var obj = msg;
                var content='<div class="profile-mine__content mb0">';
                for(var i in obj ){
                    content+=
                        '<li>'+
                        '<div class="row">'+
                        '<div class="col-md-12 profile-mine__content--title-warp">'+
                        '<p class="nowrap bold" style="font-size:16px;">'+
                        '<a class="link-primary" target="_blank" href=/getArticle/'+obj[i].article_id+'>'+obj[i].title+'</a>'+
                        '</p>'+
                        '<ul class="list-inline" style="font-size: 12px!important;line-height: 30px;">'+
                        '<li>'+
                        '<a href="#" target="_blank">'+
                        '<img src="/static/images/head.jpeg" alt="" class="img-circle" width="30" height="30">'+
                        '<span>'+obj[i].uname+'</span>'+'</a>'+
                        '</li>'+
                        '<li class="pull-right">'+
                        '<a href="#" class="link-black" target="_blank">'+
                        '<i class="margin-r-5"></i>'+'评论(5)'+'</a>'+
                        '</li>'+
                        '<li class="pull-right">'+
                        '<a href="#" class="link-black" target="_blank">'+
                        '<i class="margin-r-5"></i>'+'阅读(123)'+'</a>'+
                        '</li>'+
                        '<li>'+
                        '<a href="#" class="link-black disabled">'+
                        '<i class="margin-r-5"></i>'+obj[i].create_time+'</a>'+
                        '</li>'+
                        '</ul>'+
                        '</div>'+
                        '</div>'+
                        '</li>'
                }
                $("#box-body").html(content)
            }
        });
    });
});

// '<li class="dropdown messages-menu">'+
// <!-- Menu toggle button -->
// '<a href="#" id="message-size-btn" class="dropdown-toggle" data-toggle="dropdown">'+
// '<i class="fa fa-envelope-o">'
// '</i>'+
// '<span class="label label-success">'+'</span>'+
// '</a>'+
// '<ul class="dropdown-menu">'+
// '<li class="header">'+ "您没有未读私信"+
// '</li>'+
// '<li id="not-read-message-list">'+ "加载中..."+
// '</li>'+
// '<li class="footer">'+'<a href="/manage/messages" target="_blank">'+
// "查看所有私信"+'</a>'+'</li>'+
// '</ul>'+
// '</li>'+
// <!-- 通知-->
// '<li class="dropdown notifications-menu">'+
// '<a href="#" id="notice-size-btn" class="dropdown-toggle" data-toggle="dropdown"aria-expanded="true">'+
// '<i class="fa fa-bell-o">'+'</i>'+
// '<span class="label label-warning">'+'</span>'+
// '</a>'+
// '<ul class="dropdown-menu">'+
// '<li class="header">'+ "您没有未读通知"+
// '</li>'+ '<li id="not-read-notice-list">'+ "加载中..."+
// '</li>'+
// '<li class="footer">'+'<a href="/manage/notices">'+"查看所有通知"+'</a>'+'</li>'+
// '</ul>' +'</li>'+
// '</li>'+