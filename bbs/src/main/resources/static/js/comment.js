function Article_Comment() {
    var articleId = $("#articleId").val();
    var content = $("#comment_content").val();
    console.log(articleId);
    console.log(content);
    if(!content){
        alert("回复内容不能为空！");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "articleId":articleId,
            "content":content,
        }),
        success:function (response) {
            if(response==1){
                $("#comment_div").hide();
                window.location.reload();
            }
            else{
                if(response.code==2003){
                    var isAccepted = confirm(response.message);
                    if(isAccepted){
                        window.open("https://www.baidu.com/");
                        window.localStorage.setItem("closable", true);
                    }
                }
                alert("Error");
            }
            console.log(response);
        },
        dataType:"json"
    });
}

