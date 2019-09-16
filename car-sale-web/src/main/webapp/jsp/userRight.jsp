<%--
  Created by IntelliJ IDEA.
  User: sasa
  Date: 2019/9/11
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<div class="top_nav">
    <div class="nav_menu">
        <nav>
            <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
                <li class="">
                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                        <img src="../images/img.jpg" alt="">${emp.empName}
                        <span class=" fa fa-angle-down"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                        <li><a href="javascript:;"> 个人信息</a></li>
                        <li><a href="${pageContext.request.contextPath}/jsp/login.jsp"><i
                                class="fa fa-sign-out pull-right"></i>
                            退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
</div>
