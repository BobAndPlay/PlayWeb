/**
 * Created by zhangpeilei on 2017/5/20.
 */
function bannerHandle(){
    var mySwiper = new Swiper ('.swiper-container', {
        direction: 'horizontal',
        loop: true,
        // autoplay : 5000,
        // 如果需要分页器
        pagination: '.swiper-pagination',


        // 如果需要前进后退按钮
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',

        // 如果需要滚动条
        scrollbar: '.swiper-scrollbar',
    })
}

// }

//banner

// index/banners
$.ajax({
    url:'/index/banners',
    type:'get',
    dataType:'json',
    data:{
        type:'main'
    },
    success:function (result) {
        console.log(result)
        if(result.code==1){
           var info =  template("bannerTpl",result);
            console.log(info);
            $("#bannerInfo").html(info);
            bannerHandle();
        }
    }

})

//subjecy-category
$.ajax({
    url:'/index/allSubject',
    type:'get',
    dataType:'json',
    success:function (result) {
        console.log(result);
        if(result.code==1){
            var subjectInfo = template("subjectTpl",result);
            console.log(subjectInfo);
            $('#subjectInfo').html(subjectInfo);
        }

    }
})

//热门主播课程
$.ajax({
    url:'/index/banners',
    type:'get',
    dataType:'json',
    data:{
        type:'hot'
    },
    success:function (result) {
        console.log(result)
        if(result.code==1){
            var info =  template("hotTpl",result);
            console.log(info);
            $("#hotInfo").html(info);
            bannerHandle();
        }
    }

})
//sub-banner
var index = 0;
var ulLength = $('.content>ul>li').length;

$("#right-arrow").click(function () {
    if(ulLength-2<=index){
        index=0;
        $(".hot-live>.content>ul").offset().left=index;
    }
    index++;
    $(".hot-live>.content>ul").animate({left:(-index*305)+'px'},1,'linear');
});

$("#left-arrow").click(function () {
    // alert(index+"==")
    console.log('into message'+index)
    if(index <= 0){
        index = ulLength-3;
        console.log($(".hot-live>.content>ul"));
        $(".hot-live>.content>ul").css({left:-index*305+'px'});

        console.log($(".hot-live>.content>ul").offset().left);
    }
    index--;
    var leftNumber = $('.content>ul').offset().left;
    $("ul").animate({left:leftNumber+177+'px'},1,'linear');
});

