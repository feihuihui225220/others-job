﻿<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8"/>
    <title>用户列表</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css"/>
    #parse("/common/top.tpl")
    <link rel="stylesheet" href="/assets/css/shequyonghu.css"/>
    <script src="/assets/js/pageNavigator.js"></script>
    <script src="/assets/js/jquery-2.1.4.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=5gA7kUqnDRUiSVWG1uFpmkr2"></script>
</head>
<style type="text/css">
    /**{-webkit-box-sizing:inherit;-moz-box-sizing:inherit;box-sizing:inherit}*/
    /*居中*/
    /*.wrapper{ width:1300px;margin:0 auto; }*/

    .search {
        display: inline;
        border: 1px solid #666666;
        padding: 5px;
        background-color: #8a6d3b;
    }
    .container,
    .row{
        padding-right: 0;
        padding-left: 0;
        margin-left: 0;
        margin-right: 0;
        width: 100%;
    }

    .col-md-8,
    .col-md-4{
        padding-right: 0;
        padding-left: 0;
        margin-left: 0;
        margin-right: 0;
    }


</style>
<body onload="getServiceCategory()">
<div class="wrapper">
    #parse("/common/head.tpl")
    <div class="body bodyline pad10" style="padding-bottom: 0;height:573px;">
        #parse("/community/user/tab.tpl")
        <div class="container" id="main">
            <div class="row" style="margin-top: -8px">
                <div style="width:20%;float: left">
                    <div class="search" style="width:100%">
                        <input type="text" id="search_word" style="width:71%">
                        <button id="search" style="width:20%">搜索</button>
                    </div>
                    <table id="table" class="table table-bordered usertable trclick">
                        <tr>
                            <th style="width: 66.666%">服务商分类</th>
                            <th style="width: 33.333%">数量</th>
                        </tr>

                        #foreach ($item in $counts)
                        <tr class="service" data-id="${item.serviceId}" data-list="${item.name}">
                            <td>$!{item.name}</td>
                            <td>$!{item.count}</td>
                        </tr>
                        #end
                    </table>
                    <ul id="list" style="display:none;height:500px;overflow:auto;" class="list-group">
                    </ul>
                </div>
                <div style="width:78%;float:left;height:77%;position:absolute;border:#ccc solid 1px;margin-left: 19%;margin-bottom:0;">
                    <div style="width:100%;height:100%;position:absolute;border:#ccc solid 1px;float: right;" id="dituContent"></div>
                    <div style="position:absolute;right:0">
                        <input type="text" placeholder="半径" id="radius">
                        <button id="analysis" >分析</button>
                    </div>
                    <div style="clear: both"></div>
                </div>
                <div style="clear: both"></div>
            </div>
        </div>
    </div>
    <div id="myDiv" onclick="search()"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript">

    var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
    var myGeo = new BMap.Geocoder();
    var addArrays = [];//json返回的内容的数组里面有id,name,address,contact
    var searchAddress = [];
    var serviceCategoryArrays = [];
    //半径
    var radius = 0;
    //月坛边界的点
    var yuetan = [[116.3412, 39.923945]
        , [116.341191, 39.918342]
        , [116.341982, 39.913099]
        , [116.341281, 39.913085]
        , [116.341119, 39.910083]
        , [116.342952, 39.90863]
        , [116.341119, 39.908298]
        , [116.341155, 39.904077]
        , [116.342395, 39.904064]
        , [116.342449, 39.903178]
        , [116.356013, 39.903759]
        , [116.356175, 39.905572]
        , [116.362912, 39.90607]
        , [116.3632, 39.905005]
        , [116.364349, 39.904645]
        , [116.36735, 39.90524]
        , [116.363415, 39.908132]
        , [116.363217, 39.916004]
        , [116.36302, 39.92418]];

    createMap();
    //创建和初始化地图函数：
    //创建地图函数：
    function createMap() {

        // 初始化地图时的中点，缩放等级
        var point_ = new BMap.Point(116.3513, 39.91546);
        map.centerAndZoom(point_, 15);
//        map.disableScrollWheelZoom();//禁止使用鼠标滚轮放大缩小
//        map.disableDragging();//禁止拖拽
        map.disableDoubleClickZoom();//禁止双击放大

        yuePolygon();
    }

    function getServiceCategory() {
        $.ajax({
            url: "/care/careManager/serviceCategory",
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                if (json.categorys.length == 0) {
                    alert("接口出现问题");
                    return false;
                }
                var categorys = json.categorys;
                $.each(categorys, function (i, e) {
                    var category = {};
                    category.id = e.id;
                    category.name = e.name;
                    serviceCategoryArrays.push(category);
                });
                serviceCategoryArrays.push({id: 10086, name: '搜索结果'});
                getAddress();
            },
            error: function () {
                alert(2);
            }
        });
    }

    //AJAX获取到服务商的信息,body的onload时间调用
    function getAddress() {
        $.ajax({
            url: "/care/careManager/getAddressJson",
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                if (json.address.length == 0) {
                    alert("接口出现问题");
                    return false;
                }
                var addArrays_ = json.address;

                $.each(addArrays_, function (i, e) {
                    if (e.name) {
                        if (!e.address) {
                            e.address = "西城区白云路西里甲三号";
                        }
                        if (!e.cover_path) {
                            e.cover_path = "/assets/css/img/map_icon/44.png";
                        }
                        addArrays.push(e);
                        addPointAsFisttime(e);
                    }
                });
                $("#myDiv").text("");
                $(document).on("click.common","#analysis",function(e){
                    clearCircle();
                    radius = $("#radius").val();
                    add_circle(addArrays, radius);
                });
                $(document).off(".search");
                $(document).off(".service");
                // 打开单个服务
                $(".service").click(function () {
                    var serviceId = $(this).attr("data-id");
                    var serviceName = $(this).attr("data-list");
                    openService(serviceId, serviceName, 0);
                });
            },
            error: function () {
                alert(2);
            }
        });
    }

    //向地图中添加点，
    //addString是地点的地址，比如：南礼士路往东北走二七剧场路
    function addPoint(e) {
        var icon_path;
        for (var i = 0; i < serviceCategoryArrays.length; i++) {
            var service = serviceCategoryArrays[i];
            if (e.category_ids == service.id || e.category_ids.match(service.id) != null) {
                icon_path = "/assets/css/img/map_icon/" + service.name + ".png";
                var myIcon = new BMap.Icon(icon_path, new BMap.Size(30, 30));
                var point = new BMap.Point(e.longitude, e.latitude);
                var marker = new BMap.Marker(point, {icon: myIcon});
                marker.addEventListener('click', function () {
                    openInfo_point(e, point);
                });
                map.addOverlay(marker);//添加标记点
            }
        }
    }

    function addPointAsFisttime(e) {
        var icon_path_ = "/assets/css/img/map_icon/marker_red_sprite.png";
        var myIcon = new BMap.Icon(icon_path_, new BMap.Size(30, 30));
        var point = new BMap.Point(e.longitude, e.latitude);
        var marker = new BMap.Marker(point, {icon: myIcon});
        marker.setOffset(new BMap.Size(8, -10));
        marker.addEventListener('click', function () {
            openInfo_point(e, point);
        });
        map.addOverlay(marker);//添加标记点
    }

    //打开地图中的点的提示框
    function openDetail(serviceId) {
        for (var i = 0; i < addArrays.length; i++) {
            var vendorInfo = addArrays[i];
            if (vendorInfo.id == serviceId) {
                var point = new BMap.Point(vendorInfo.longitude, vendorInfo.latitude);
                openInfo_point(vendorInfo, point);
            }
        }
    }

    //按服务id显示该类服务的点,type=0时正常用，type=1时用于搜索
    function openService(serviceId, name, type) {
        $("#list").css("display", "").empty()
                .append("<li class='list-group-item' style='background: #d5c8a0;'>" +
                "<span id='service_name'></span>" +
                "<a id='back' class='btn btn-default' style='float: right'>返回</a>" +
                "</li>");
        $("#service_name").text(name);
        $("#table").css("display", "none");
        setBack();
        map.clearOverlays();//清除点(覆盖物)
        yuePolygon();
        var addressArr = [];//用于搜索时和正常的列表的区分
        var serviceListArr = [];//把相关服务存放在这个数组中
        switch (type) {
            case 0:
                addressArr = addArrays;
                addressArr = addArrays;
                addressArr = addArrays;
                break;
            case 1:
                addressArr = searchAddress;
                break;
        }
        $.each(addressArr,function(i,e){
            if (!e.star) {
                e.star = "暂无评价";
            }
            setCoverPath(e);
            if(e.category_ids){
                var category_ids=e.category_ids;
                if(!serviceId){
                    console.log(serviceId);
                }else if(serviceId == "10086"){
                    serviceListArr.push(e);
                }else if(category_ids == serviceId){
                    serviceListArr.push(e);
                }else if(category_ids.match(serviceId)){
                    serviceListArr.push(e);
                }
            }
        });
        $.each(serviceListArr,function(i,e){
            setServiceList(e,name);
        });
        $(".service-detail").click(function () {
            var serviceId = $(this).attr("data-id");
            openDetail(serviceId);
        });

        $(document).on("click.service","#analysis",function(e){
            clearCircle();
            radius = $("#radius").val();
            add_circle(serviceListArr, radius);
        });
        $(document).off(".search");
        $(document).off(".common");
    }

    //给每个服务在地图上标记上点，在列表中加入该服务
    function setServiceList(service,name) {
        addPointAsFisttime(service);
        var tag_string="";
        if(service.tag_ids){
            var tag_ids = service.tag_ids.split(",");
            if(tag_ids.length == 1){
                tag_string = "<img src='/assets/css/img/servcie_tag_icon/"+tag_ids[0]+".png'>";
            }else{
                $.each(tag_ids,function(i,tag_id){
                    tag_string += "<img src='/assets/css/img/servcie_tag_icon/"+tag_id+".png'>";
                });
            }
        }else{
            tag_string="无标签";
        }
        service.cover_path="/assets/css/img/map_icon/"+name+".png";
        $("#list").append("<li class='list-group-item service-detail' data-id='" + service.id + "' >"
                + "<div class='media'>"
                + "<a class='pull-right' href='#'>"
                + "<img class='media-object' src='" + service.cover_path + "' width='80' height='80'>"
                + "</a>"

                + "<div class='media-body'>"
                + "<p class='media-heading' style='margin: 0px'>" + service.name + "</p>"

                + "<p style='margin: 0px'>"
                + service.star + "<br>"
                + "电话：" + service.contact_phone
                + "</p>"
                + "<p id='service_tag'>"+tag_string
                + "</p>"
                + "</div>"
                + "</div>"
                + "</li>");
    }

    //给返回按钮添加时间
    function setBack() {
        $("#back").click(function () {
            $("#list").css("display", "none");
            $("#table").css("display", "");
            map.clearOverlays();//清除点(覆盖物)
            yuePolygon();
            var point_ = new BMap.Point(116.3513, 39.91546);
            map.centerAndZoom(point_, 15);
            for (var i = 0; i < addArrays.length; i++) {
                var e = addArrays[i];
                addPointAsFisttime(e);
            }
        });
    }

    //地图里的弹出信息框的尺寸
    var opts = {
        width: 400   // 信息窗口宽度
//        height: auto   // 信息窗口高度
    };

    // 地图上的信息框
    function openInfo_point(e, point) {
        if (e.contact == "" || e.contact == null || e.contact == "null" || e.contact == "暂无") {
            e.contact = "暂无介绍";
        }
        if (e.star == "" || e.star == null || e.star == "null" || e.star == "暂无") {
            e.star = "暂无评价";
        }
        setCoverPath(e);
        var sContent = "<p style='font-size: small;line-height: 1.2;'>" + e.name + "</p>" +
                "<p style='font-size: small'>" + e.address + "</p>" +
                "<p style='font-size: small'>" + e.star + "</p>" +
                "<img src='" + e.cover_path + "' width='80' height='80'>" +
                "<p >" + e.contact_phone + "</p>" +
                "<p style='font-size: small'>" + e.contact + "</p>";
        var infoWindow = new BMap.InfoWindow(sContent, opts);  // 创建信息窗口对象
        map.openInfoWindow(infoWindow, point); //开启信息窗口
//        map.centerAndZoom(point, 17);
    }

    //设置图标图案
    function setCoverPath(e) {
        if (!e.cover_path) {
            for (var i = 0; i, serviceCategoryArrays.length; i++) {
                var service = serviceCategoryArrays[i];
                if (e.category_ids == service.id || e.category_ids.match(service.id) != null) {
                    e.cover_path = "/assets/css/img/map_icon/" + service.id + ".png";
                }
            }
        }
    }

    //添加服务商范围（圆）
    var circle_arr = [];
    function add_circle(addressArrays, radius) {
        $.each(addressArrays, function (i, address) {
            var point = new BMap.Point(address.longitude, address.latitude);
            var circle = new BMap.Circle(point, radius, {
                strokeColor: "green",
                fillColor: "green",
                strokeWeight: 1,
                strokeOpacity: 0.1,
                fillOpacity: 0.2
            }); //创建圆
            map.addOverlay(circle);//增加圆
            circle_arr.push(circle);
        });
    }

    //清除圆
    function clearCircle() {
        if (circle_arr.length >= 1) {
            $.each(circle_arr, function (i, e) {
                map.removeOverlay(e);
            });
        }
    }

    //月坛社区地图上的多边形
    function yuePolygon() {
        var point_arr = [];

        $.each(yuetan, function (i, e) {
            var a0 = e[0];
            var a1 = e[1];
            point_arr[i] = new BMap.Point(a0, a1);
        });
        var polygon = new BMap.Polygon(point_arr, {
            strokeColor: "blue",
            strokeWeight: 2,
            strokeOpacity: 0.5,
            fillOpacity: 0.3
        });  //创建多边形

        //添加覆盖物
        map.addOverlay(polygon);//增加多边形
    }

    //搜索
    $("#search").click(function () {
        var search_word = $("#search_word").val();
        if (!search_word) {
            alert("请输入搜索关键词");
            return false;
        }
        $.ajax({
            url: "/care/careManager/map/search/" + search_word,
            type: 'GET',
            dataType: 'json',
            success: function (json) {
                if (json.address.length == 0) {
                    alert("未搜索到服务商");
                } else {
                    searchAddress = json.address;
                    $.each(searchAddress, function (i, e) {
                        if (!e.address) {
                            e.address = "西城区白云路西里甲三号";
                        }
                        if (!e.cover_path) {
                            e.cover_path = "/assets/css/img/map_icon/44.png";
                        }
                    });
                    map.clearOverlays();//清除点(覆盖物)
                    $("#table").css("display", "none");
                    $("#list").css("display", "");
                    openService("10086", "搜索结果", 1);
                    $("#myDiv").text("");
                    $(document).on("click.search","#analysis",function(e){
                        clearCircle();
                        radius = $("#radius").val();
                        add_circle(searchAddress, radius);
                    });
                    $(document).off(".common");
                    $(document).off(".service");
                }
            },
            error: function () {
                alert(2);
            }
        });
    });
</script>
</body>
</html>