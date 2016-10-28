<%@ tag body-content="scriptless" trimDirectiveWhitespaces="true" %>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="bodyTitle" type="java.lang.String" rtexprvalue="true"
              required="true" %>
<%@ attribute name="extraHeadContent" fragment="true" required="false" %>
<%@ attribute name="extraNavigationContent" fragment="true" required="false" %>
<%@ include file="/WEB-INF/views/base.jspf" %>
<template:main htmlTitle="${htmlTitle}" bodyTitle="${bodyTitle}">
    <jsp:attribute name="headContent">
        <jsp:invoke fragment="extraHeadContent" />
    </jsp:attribute>
    <jsp:attribute name="navigationContent">
    <div class="left side-menu">
                <div class="sidebar-inner slimscrollleft">
                    <!--- Divider -->
                    <div id="sidebar-menu">
                        <ul>
                            <li>
                                <a href="<c:url value="/kmt_1000_1000.act"/>" class="waves-effect"><i class="md md-home"></i><span> Dashboard </span></a>
                            </li>
                            
                             <li class="has_sub">
                                <a href="#" class="waves-effect active"><i class="md md-people"></i><span> People </span><span class="pull-right"><i class="md md-add"></i></span></a>
                                <ul class="list-unstyled">
                                    <li class="active"><a href="<c:url value="/kmt_2000_1000.act"/>">Manage Users</a></li>
                                    <li><a href="<c:url value="/kmt_2000_2000.act"/>">Manage Teachers</a></li>
                                    <li><a href="<c:url value="/kmt_2000_3000.act"/>">Manage Students</a></li>
                                </ul>
                            </li>
                            
                            
                            <li>
                                <a href="<c:url value="/dashboard/contact"/>" class="waves-effect"><i class="md md-contacts"></i><span> Contact List </span></a>
                            </li>
                            <sec:authorize access="hasRole('DIRECTOR')">
                            <li>
                                <a href="<c:url value="/dashboard/users"/>" class="waves-effect"><i class="md md-people"></i><span> Users </span></a>
                            </li>
                            </sec:authorize>
                            <sec:authorize access="hasRole('TEACHER')">
                            <li>
                                <a href="<c:url value="/dashboard/students"/>" class="waves-effect"><i class="md md-people"></i><span> My Students </span></a>
                            </li>
                            </sec:authorize>                             
                            <li>
                                <a href="<c:url value="/dashboard/payment"/>" class="waves-effect"><i class="md  md-attach-money"></i><span> Payment </span></a>
                            </li>                         
                            <li>
                                <a href="<c:url value="/dashboard/event"/>" class="waves-effect"><i class="md md-event"></i><span> Event </span></a>
                            </li>                        
                            <li>
                                <a href="<c:url value="/dashboard/classroom"/>" class="waves-effect"><i class="md md-event"></i><span> Classroom </span></a>
                            </li>                        
                            <li>
                                <a href="<c:url value="/dashboard/student/export"/>" class="waves-effect"><i class="md md-event"></i><span> Download Excel </span></a>
                            </li>
                            <li>
                                <a href="calendar.html" class="waves-effect"><i class="md md-event"></i><span> Calendar </span></a>
                            </li>
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
     <jsp:invoke fragment="extraNavigationContent" />
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</template:main>
