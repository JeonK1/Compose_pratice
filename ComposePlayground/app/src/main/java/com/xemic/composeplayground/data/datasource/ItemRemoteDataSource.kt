package com.xemic.composeplayground.data.datasource

import com.xemic.composeplayground.data.model.ItemInfo
import javax.inject.Inject

class ItemRemoteDataSource @Inject constructor() {
    fun getItemListAll() = listOf(
        ItemInfo(0, CategoryList[0],"감자감자햇감자", "https://mediahub.seoul.go.kr/wp-content/uploads/2016/09/61a2981f41200ac8c513a3cbc0010efe.jpg", 5000),
        ItemInfo(1, CategoryList[0],"고구마유시", "https://mblogthumb-phinf.pstatic.net/MjAxNzA5MDFfMTcx/MDAxNTA0MjU1NDUyMjMy.wj-KhXsSsDMK2_jzX4CGb9muFTpCXDxhg7ZRY_vOPOEg.BlNYVqXOZRU305Cn-w7089V2JfD7DOjE4r5EEth5lgMg.JPEG.nong-up/%EA%B3%A0%EA%B5%AC%EB%A7%882.JPG?type=w800", 5000),
        ItemInfo(2, CategoryList[0],"호.박.고.구.마 호박.고구마!!", "https://post-phinf.pstatic.net/MjAxODAxMTJfMjE4/MDAxNTE1NzU2MDk3MTk5.ERRmAm5lI2XOl8QKbmyjypP8bXq7bjkIpQFo7OET3Tkg.QhIqvUFhgcC7TaTQ-Jh1onX1yOxrMtKHZRcuGKr3wjgg.JPEG/3.jpg?type=w1200", 10000),
        ItemInfo(3, CategoryList[1],"어깨 좁은 경호원", "https://image.hmall.com/static/9/3/48/38/2138483975_0.jpg?RS=600x600&AR=0", 5000),
        ItemInfo(4, CategoryList[1],"술 안먹는 경호원", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR-di1rS_cga-9C75rS5HyTRK3BUx2FG0CRGg&usqp=CAU", 5000),
        ItemInfo(5, CategoryList[1],"표절 싫어하는 경호원", "https://sitem.ssgcdn.com/74/47/00/item/1000247004774_i1_1200.jpg", 7000),
        ItemInfo(6, CategoryList[1],"듬직한 경호원", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyy22uYkRjpvHCi5b1xfHdPwS5YgtHQb-Jypau9hMEG--nRenXfsaPDIY_SGVGXUeunyk&usqp=CAU", 6000),
        ItemInfo(7, CategoryList[1],"어른스러운 경호원", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ7EIwgcDehfUSLuWl-i9oLhir8kHvznu_tTg&usqp=CAU", 2000),
        ItemInfo(8, CategoryList[2],"안 매운 비빔면", "https://cdn.eyesmag.com/content/uploads/sliderImages/2020/06/03/for-export-purposes-samyang-buldak-02-aadf2255-a4d8-42f6-aebc-9d1bad2a91e4.jpg", 5500),
        ItemInfo(9, CategoryList[2],"건강한 라면", "https://img.danawa.com/prod_img/500000/459/239/img/1239459_1.jpg?shrink=330:330&_v=20210413140309", 56000),
        ItemInfo(10, CategoryList[2],"언젠간 먹어보고싶은 라면", "https://image.homeplus.kr/td/b21a04dd-b9eb-4e31-b923-799bac9baa0c", 50100),
        ItemInfo(11, CategoryList[2],"저렴한 라면", "https://t1.daumcdn.net/cfile/tistory/1226A33C4DD0AA6414", 3000),
        ItemInfo(12, CategoryList[2],"살찌는 음식", "https://img.danawa.com/prod_img/500000/155/117/img/1117155_1.jpg?shrink=330:330&_v=20210712143816", 2000),
        ItemInfo(13, CategoryList[2],"조별리그 탈락한 초콜릿", "https://contents.lotteon.com/itemimage/_v000638/LM/88/01/06/26/36/82/2_/00/1/LM8801062636822_001_1.jpg/dims/optimize/dims/resizemc/400x400", 11000),
        ItemInfo(14, CategoryList[2],"중독성 없는 초콜릿", "https://post-phinf.pstatic.net/MjAxOTEwMDdfMjc3/MDAxNTcwNDIxMjQzNjg1.wZ3OTfLf5-BWHWLZXhAbRCMxDldESvokUzs7ZVpb4Y0g.AuJx6d-Nl9ztK_xOjj5jHteRkCPeyiFOmvH5ibtNdPYg.JPEG/maltesers.jpg?type=w1200", 21000),
        ItemInfo(15, CategoryList[2],"딱딱한 사탕", "https://t1.daumcdn.net/cfile/tistory/996BB9465EC4C64B27", 15000),
        ItemInfo(16, CategoryList[2],"국민 아이스크림", "https://img.vogue.co.kr/vogue/2019/03/style_5c9c8c4ba29e7-930x523.jpg", 53000),
        ItemInfo(17, CategoryList[2],"요맘떄 아이스크림", "https://image.homeplus.kr/td/868a01f5-76a0-482d-be7b-b5bb04b19bb0", 9000),
    )
}