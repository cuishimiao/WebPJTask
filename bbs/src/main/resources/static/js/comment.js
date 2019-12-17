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
                if(response==0){
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

function Question_Comment() {
    var questionId = $("#questionId").val();
    var content = $("#question_reply").val();
    console.log(questionId);
    console.log(content);
    if(!content){
        alert("回答的内容不能为空！");
        return;
    }
    $.ajax({
        type: "POST",
        url: "/questionreply",
        contentType: 'application/json',
        data: JSON.stringify({
            "questionId":questionId,
            "content":content,
        }),
        success:function (response) {
            if(response==1){
                $("#comment__div").hide();
                window.location.reload();
            }
            else{
                alert("Error");
            }
            console.log(response);
        },
        dataType:"json"
    });
}

// function accepted(){
//     var ajaxquestion_Id = $("#ajaxquestion_Id").val();
//     var replyId = $("#replyId").val();
//     var responserName=$("#responserName").val();
//     console.log(ajaxquestion_Id);
//     console.log(replyId);
//     console.log(responserName);
//     alert("问题ID"+ajaxquestion_Id+"回复ID"+replyId+"回复者名字"+responserName)
//     $.ajax({
//         type: "POST",
//         url: "/Accept",
//         contentType: 'application/json',
//         data: JSON.stringify({
//             "ajaxquestion_Id":ajaxquestion_Id,
//             "replyId":replyId,
//             "c":responserName
//         }),
//         success:function (response) {
//             if(response==1){
//                 window.location.reload();
//             }
//             else{
//                 alert("Error");
//             }
//             console.log(response);
//         },
//         dataType:"json"
//     });
// }

// function lk() {
//     var aid = $("#aid").val();
//     console.log(aid);
//     $.ajax({
//         type: "POST",
//         url: "/like",
//         contentType: 'application/json',
//         data: JSON.stringify({
//             "Id":aid
//         }),
//         success:function (response) {
//             if(response==1)
//                 $("#autore").load(location.href + " #autore");
//                 window.location.reload();
//         },
//         dataType:"json"
//     });
// }