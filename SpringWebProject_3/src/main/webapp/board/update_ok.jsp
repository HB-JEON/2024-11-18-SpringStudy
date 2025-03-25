<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${bCheck==true }">
  <c:redirect url="detail.do?no=${no }"/>
</c:if>
<c:if test="${bCheck==false }">
  <script>
    alert("비밀번호를 확인 해주세요.");
    history.back()
  </script>
</c:if>
