/**
 * Created by zhangpeilei on 2017/5/20.
 */
// window.load = function () {
    var mySwiper = new Swiper ('.swiper-container', {
        direction: 'horizontal',
        loop: true,
        autoplay : 5000,
        // 如果需要分页器
        pagination: '.swiper-pagination',


        // 如果需要前进后退按钮
        nextButton: '.swiper-button-next',
        prevButton: '.swiper-button-prev',

        // 如果需要滚动条
        scrollbar: '.swiper-scrollbar',
    })
// }

//banner

// index/banners
$.ajax({
    url:'/index/banners',
    type:'get',
    dataType:'json',
    success:function (result) {
        console.log(result)
        if(result.code==1){
           var info =  template("bannerTpl",result.data);
            $("#bannerInfo").html(info);
        }
    }

})

