
<script setup>
import { onMounted, ref } from 'vue';
import { useRoute, useRouter } from "vue-router";
import {selectOne,remove,update} from "@/api/qna.js";

const num = ref("");
const writer = ref("");
const count = ref("");
const wdate = ref("");
const title = ref("");
const content = ref("");

const currentRoute = useRoute();
const router = useRouter();

// 파라미터 받기
const param = ref(currentRoute.params.num);

const key = param.value;
const isModify = ref(false);

onMounted(readOne);

function readOne() {
selectOne(key,response => {
  const result = response.data.data;
    num.value = result.num;
    title.value = result.title;
   content.value = result.content;
   writer.value = result.writer;
   count.value = result.count;
   wdate.value = result.wdate;
    
  },error => { 
    console.log(error);
  })
}



function qnaDelete() {
  remove(key,
    response => {
      if(response.data.code === 200){
        alert("삭제 완료!");
    }
    else{
        alert("오류 발생!");
    }
    
   router.push({ name: "Qna" });
    },
    error => {
      console.log(error);
    }) 

    
}

function qnaUpdate() {

  const update_qna = {
    num : num.value,
    title : title.value,
    content : content.value
  }

  update(update_qna,
    response => {
      if(response.data.code === 200){
        alert("수정 완료!");
    }
    else{
        alert("오류 발생!");
    }

    
   router.push({ name: "Qna" });
    },
    error => {
      console.log(error);
    }) 

}
function enableEditing() {
    isModify.value = !isModify.value;
    document.getElementById("title").readOnly = isModify.value;
    document.getElementById("content").readOnly = isModify.value;
    var updateButton = document.getElementById("btnUpdateComplete");
    if (isModify.value) {
        updateButton.style.display = "none"; // 수정중일 때 버튼 표시
    } else {
        updateButton.style.display = "inline-block";// 수정중이 아닐 때 버튼 숨김
    }
}
</script>

<template>
  <div class="about">
    <div class="container">
		<form id="form1" class="form-horizontal">
			<h2>Spring Boot board Management</h2>

			<div class="form-group">
				<label>번호:</label> 
				<input type="text" class="form-control" id="num" v-model="num" readonly> 
			</div>

      <div class="form-group">
				<label>글쓴이:</label> 
				<input type="text" class="form-control" id="writer" v-model="writer" readonly> 
			</div>

      <div class="form-group">
				<label>날짜:</label> 
				<input type="text" class="form-control" id="wdate" v-model="wdate" readonly> 
			</div>

      <div class="form-group">
				<label>조회수:</label> 
				<input type="text" class="form-control" id="count" v-model="count" readonly> 
			</div>

			<div class="form-group">
				<label>제목:</label> 
				<input type="text" class="form-control" id="title" v-model="title" readonly>
			</div>

			<div class="form-group">
    <label for="content">글 내용:</label>
    <textarea class="form-control" id="content" v-model="content" style=" height: 200px;" readonly></textarea>
  </div>

  <div class="container">
    <div class="btn-group" style="margin-right: 10px;">
        <input type="button" class="btn btn-primary" value="삭제" id="btnDelete" @click="qnaDelete()" /> 
    </div>
    <div class="btn-group"  style="margin-right: 10px;">
        <input type="button" class="btn btn-primary" value="수정" id="btnUpdate" @click="enableEditing()" /> 
    </div>

    <div class="btn-group">
        <input type="button" class="btn btn-primary" value="수정 완료" id="btnUpdateComplete" @click="qnaUpdate()" style="display: none;" /> 
    </div>
</div>

		</form>
	</div>
  </div>
</template>

<style>
@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
