$(function () {
   $(document).on('click',"#user_Article",function () {
        var page = $("#user_Article").attr("value");
        var content ='<ul style="list-style: none">';
        $.ajax({
            url:page,
            type:"GET",
            success:function (msg) {
                var obj = msg;
                for(var i in obj){
                    content+='<li>'+obj[i].title+'</li>'+
                        '<li>'+obj[i].create_time+'</li>'
                }
                content+='</ul>';
                $("#data").html(content);
            }
        });

   });
});
// content+=
//     '<li>'+
//     '<div class="row">'+
//     '<div class="col-md-12 profile-mine__content--title-warp">'+
//     '<p class="nowrap bold" style="font-size:16px;">'+
//     '<a class="link-primary" target="_blank" href=/getArticle/'+obj[i].article_id+'>'+obj[i].title+'</a>'+
//     '</p>'+
//     '<ul class="list-inline" style="font-size: 12px!important;line-height: 30px;">'+
//     '<li>'+
//     '<a href="#" target="_blank">'+
//     '<img src="../images/head.jpeg" alt="" class="img-circle" width="30" height="30">'+
//     '<span>'+obj[i].uname+'</span>'+'</a>'+
//     '</li>'+
//     '<li class="pull-right">'+
//     '<a href="#" class="link-black" target="_blank">'+
//     '<i class="margin-r-5"></i>'+'评论(5)'+'</a>'+
//     '</li>'+
//     '<li class="pull-right">'+
//     '<a href="#" class="link-black" target="_blank">'+
//     '<i class="margin-r-5"></i>'+'阅读(123)'+'</a>'+
//     '</li>'+
//     '<li>'+
//     '<a href="#" class="link-black disabled">'+
//     '<i class="margin-r-5"></i>'+obj[i].create_time+'</a>'+
//     '</li>'+
//     '</ul>'+
//     '</div>'+
//     '</div>'+
//     '</li>'