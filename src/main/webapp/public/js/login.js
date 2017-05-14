/**
 * Created by zhangpeilei on 2017/5/13.
 */
$("#loginForm").submit(function (e) {
    if($("#username").val()==""||$("#pwd").val()==""){
        console.log("黑河");
       $(".nametip").html("用户名或密码不能为空");
    }
    var loginInfo = $(this).serialize();
    console.log(loginInfo);
    $.ajax({
        url:'/user/login',
        type:'post',
        data:loginInfo,
        success:function (data) {
         var data =  JSON.parse(data);
            console.log(data);
            if(data.code=="1"){
             location.href="/view/index.html"
         }else if(data.code=="2"){
             $(".nametip").html(data.msg);
         }
        }
    })
    e.preventDefault();
})