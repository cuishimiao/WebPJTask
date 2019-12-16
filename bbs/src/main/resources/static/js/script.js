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


});

