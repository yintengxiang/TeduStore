<%--
  Created by IntelliJ IDEA.
  User: 张启阳
  Date: 2018/8/29
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 左边栏-->
<div id="leftsidebar_box" class="lf">
    <div class="line"></div>
    <dl class="my_order">
        <dt >我的订单
            <img src="../images/myOrder/myOrder2.png">
        </dt>
        <dd class="first_dd"><a href="orders.html">全部订单</a></dd>
        <dd>
            <a href="#">
                待付款
                <span><!--待付款数量--></span>
            </a>
        </dd>
        <dd>
            <a href="#">
                待收货
                <span><!--待收货数量-->1</span>
            </a>
        </dd>
        <dd>
            <a href="#">
                待评价<span><!--待评价数量--></span>
            </a>
        </dd>
        <dd>
            <a href="#">退货退款</a>
        </dd>
    </dl>



    <dl class="address">
        <dt>收货地址<img src="../images/myOrder/myOrder2.png"></dt>
        <dd><a href="../address/list.do">地址管理</a></dd>
    </dl>
    <dl class="count_managment">
        <dt>帐号管理<img src="../images/myOrder/myOrder2.png"></dt>
        <dd><a href="../user/change_info.do">我的信息</a></dd>
        <dd><a href="../user/change_password.do">安全管理</a></dd>
    </dl>
</div>