<%@ page language="java" %>
<%@ page contentType="text/html" %>
<%@ taglib uri="/WEB-INF/tlds/struts-template.tld" prefix="template" %>

<template:insert template="/template.jsp">
  <template:put name="title" content="Echo" direct="true"/>
  <template:put name="header" content="/header.jsp"/>
  <template:put name="sidebar" content="/sidebar.jsp"/>
  <template:put name="main" content="/echo/echoMain.jsp"/>
  <template:put name="footer" content="/footer.html"/>
</template:insert>