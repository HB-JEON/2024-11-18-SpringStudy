<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
  <c:when test="${msg=='NO ID' }">
    <script>
      alert("아이디가 존재하지 않습니다.")
      history.back();
    </script>
  </c:when>
  <c:when test="${msg=='NO PWD' }">
    <script>
      alert("비밀번호를 확인 해주세요.")
      history.back();
   </script>
  </c:when>
  <c:otherwise>
    <c:redirect url="../databoard/list.do"></c:redirect>
  </c:otherwise>
</c:choose>