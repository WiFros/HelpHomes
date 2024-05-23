
<script setup>
import { ref } from 'vue';
import {  useRouter } from "vue-router";
import {selectOne,remove,update} from "@/api/qna.js";
import QnABoard from './components/QnABoard.vue';
const num = ref("");
const writer = ref("");
const count = ref("");
const wdate = ref("");
const title = ref("");
const content = ref("");

const router = useRouter();

// 파라미터 받기
const isModify = ref(false);

function readOne(selectNum) {
selectOne(selectNum,response => {
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
  remove(num.value,
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

  <div class ="row mt-4 container-fluid">

    <div class="col-lg-7 ">
      <QnABoard @clickQna="readOne"/>
    </div>

    <div class="col-lg-5 ">
      <div class="card mb-3">
        <div class="card-header pb-3">
          <h5>질문</h5>
        </div>

        <div class="col card-body pt-0">
          <div class ="row">
            <div class="form-group col-lg-3">
 
              <input type="text" class="form-control" id="num" v-model="num" readonly> 
            </div>

            <div class="form-group  col-lg-3">
 
              <input type="text" class="form-control" id="writer" v-model="writer" readonly> 
            </div>

            <div class="form-group  col-lg-3">
 
              <input type="text" class="form-control" id="wdate" v-model="wdate" readonly> 
            </div>

            <div class="form-group  col-lg-3">
 
              <input type="text" class="form-control" id="count" v-model="count" readonly> 
            </div>
          </div>

          <div class="form-group"> 
            <input type="text" class="form-control" id="title" v-model="title" readonly>
          </div>

          <div class="form-group">
          
            <textarea class="form-control" id="content" v-model="content" style=" height: 150px;" readonly></textarea>
          </div>

            <div class="btn-group">
                <input type="button" class="btn btn-danger" value="삭제" id="btnDelete" @click="qnaDelete()" /> 
            </div>

            <div class="btn-group mx-3">
                <input type="button" class="btn btn-primary" value="수정 하기" id="btnUpdate" @click="enableEditing()" /> 
            </div>

            <div class="btn-group">
                <input type="button" class="btn btn-primary" value="수완료" id="btnUpdateComplete" @click="qnaUpdate()" style="display: none;" /> 
            </div>
          </div>
      </div> 

      <div class="card">
        <div class="card-header pb-3">
          <h5>답변</h5>
        </div>

        <div class="col card-body pt-0">
          <div class ="row">
            <div class="form-group col-lg-3">
 
              <input type="text" class="form-control" id="num" v-model="num" readonly> 
            </div>

            <div class="form-group  col-lg-3">
 
              <input type="text" class="form-control" id="writer" v-model="writer" readonly> 
            </div>

            <div class="form-group  col-lg-3">
 
              <input type="text" class="form-control" id="wdate" v-model="wdate" readonly> 
            </div>

            <div class="form-group  col-lg-3">
 
              <input type="text" class="form-control" id="count" v-model="count" readonly> 
            </div>
          </div>


          <div class="form-group">
          
            <textarea class="form-control" id="content" v-model="content" style=" height: 150px;" readonly></textarea>
          </div>

          </div>
      </div> 
    </div>
  </div>
</template>

<style>
</style>
