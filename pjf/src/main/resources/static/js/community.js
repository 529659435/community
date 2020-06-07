

/**
 *提交回复
 */
function post() {

    var questionId = $("#question_id").val();
    var content = $("#comment_coneent").val();
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": questionId,
            "types": 1,
            "content": content
        }),

        success: function (response) {
            if (response.code == 200) {
                $("#comment_coneent").hide();
            } else {
                //实现提示未登录，点击登录后，跳转回首页
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=3aa17e57a080a05be3fa&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
            console.log(response);
        },
        dataType: "json"

    });
}

/**
 * 展开二级评论
 */
function collapseComments(e){

    var id = e.getAttribute("data-id");
    var comments = $("#comment-"+id);

    console.log(id);
    //获取一下二级评论展开状态
    var collapse = e.getAttribute("data-collapse");
    if(collapse){
        //折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse","in");
        e.classList.remove("active");
    }else{
        //展开二级评论
        comments.addClass("in");
        //标记二级评论展开状态
        e.setAttribute("data-collapse","in");
        e.classList.add("active");
    }




}