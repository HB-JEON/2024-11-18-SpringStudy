<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
 margin-top: 50px;
}
.row{
  margin: 0px auto;
  width: 800px;
}
p{
  overflow: hidden;
  white-space: nowrap;
  text-overflow: ellipsis;
}
</style>
</head>
<body>
<div class="container">
   <div class="row">
    <table class="table">
     <tr>
      <td width=40% class="text-center" rowspan="8">
        <img :src="'https://www.menupan.com'+vo.poster"
         style="width:380px;height: 300px" class="img-rounded">
      </td>
      <td width="60%" colspan="2">
        <h3>{{vo.name}}&nbsp;
        <span style="color:orange;"></span></h3>
      </td>
     </tr>
     <tr>
       <td width=15% style="color: gray">음식종류</td>
       <td width=45%></td>
     </tr>
     <tr>
       <td width=15% style="color: gray">주소</td>
       <td width=45%></td>
     </tr>
     <tr>
       <td width=15% style="color: gray">전화</td>
       <td width=45%></td>
     </tr>
     <tr>
       <td width=15% style="color: gray">가격대</td>
       <td width=45%></td>
     </tr>
     <tr>
       <td width=15% style="color: gray">주차</td>
       <td width=45%></td>
     </tr>
     <tr>
       <td width=15% style="color: gray">영업시간</td>
       <td width=45%></td>
     </tr>
     <tr>
       <td width=15% style="color: gray">테마</td>
       <td width=45%></td>
     </tr>
    </table>
    <table class="table">
      <tr>
       <td></td>
      </tr>
    </table>
    <div style="height: 20px"></div>
    <table class="table">
      <tr>
        <td>
          <div id="piechart_3d" style="width: 900px; height: 500px;"></div>
        </td>
      </tr>
    </table>
   </div>
  </div>
  <script>
    let detailApp=Vue.createApp({
    	data() {
    		return {
    			fno: ${param.fno},
    			vo: {}
    		}
    	},
    	mounted() {
    		axios.get('../food/detail_vue.do', {
    			params: {
    				fno: this.fno
    			}
    		}).then(res => {
    			console.log(res.data)
    			this.food_vo=res.data.vo
    		}).catch(error => {
    			console.log(error.response)
    		})
    	}
    }).mount(".container")
  </script>
</body>
</html>