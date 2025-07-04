<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
      @Controller : JSTL / EL
         = JSP(X) = 새로운 JSP 생성
      @RestController : JSON = Vue / Ajax
         = JSP의 변경 X
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="breadcumb-area" style="background-image: url(../img/bg-img/breadcumb.jpg);">
        <div class="container h-100">
            <div class="row h-100 align-items-center">
                <div class="col-12">
                    <div class="bradcumb-title text-center">
                        <h2>예약 정보</h2>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="breadcumb-nav">
        <div class="container">
            <div class="row">
                <div class="col-12">
                  <table class="table">
                    <tr>
                      <th class="text-center">예약 번호</th>
                      <th></th>
                      <th>예약 고객 ID</th>
                      <th class="text-center">업체명</th>
                      <th class="text-center">예약일</th>
                      <th class="text-center">예약 시간</th>
                      <th class="text-center">예약 인원</th>
                      <th class="text-center">예약 등록일</th>
                      <th class="text-center">비고</th>
                    </tr>
                    <c:forEach var="vo" items="${list }">
                      <tr>
                        <td class="text-center">${vo.rno }</td>
                        <td class="text-center">
                          <img src="https://www.menupan.com${vo.fvo.poster }" style="width: 35px; height: 35px;">
                        </td>
                        <td>${vo.userid }</td>
                        <td>${vo.fvo.name }</td>
                        <td class="text-center">
                          ${vo.rday }
                        </td>
                        <td class="text-center">${vo.rtime }</td>
                        <td class="text-center">${vo.rinwon }</td>
                        <td class="text-center">${vo.dbday }</td>
                        <td class="text-center">
                         <c:if test="${vo.isReserve==0 }">
                           <a href="../reserve/reserve_ok.do?rno=${vo.rno }" class="btn btn-sm btn-success">승인 대기</a>
                         </c:if>
                         <c:if test="${vo.isReserve==1 }">
                           <span class="btn btn-sm btn-default">승인 완료</span>
                         </c:if>
                        </td>
                      </tr>
                    </c:forEach>
                  </table>
                </div>
            </div>
        </div>
    </div>
    <section class="single_blog_area section_padding_80" id="reserveApp">
        <div class="container">
            <div class="row justify-content-center">
              <div class="col-12 col-lg-12">
                <div class="row no-gutters">
                </div>
              </div>
            </div>
        </div>
    </section>
</body>
</html>