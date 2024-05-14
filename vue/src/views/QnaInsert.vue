<script setup>
import { ref } from "vue"
import { useRouter } from "vue-router";
import { insert } from "@/api/qna";

const writer = ref("")
const title = ref("")
const content = ref("")
// const customers = ref([]) //전체 데이터 담을 배열


const router = useRouter();//setup단계에서 찾아놓기

function qnaInsert() {
  const new_qna = {
    writer: writer.value,
    title: title.value,
    content: content.value,
  }

  insert(new_qna)

  alert('등록 되었습니다!');

  writer.value = '';
  title.value = '';
  content.value = '';

  //리스트 화면으로 넘어가기  
  router.push({ path: '/qna' });//script 방식으로 넘어가기
}

</script>

<template>
  <div class="about">

    <div class="container">
      <form id="form1" class="form-horizontal">
        <h2>Q&A 등록</h2>
        <div class="form-group">
          <label>작성자:</label> <input type="text" class="form-control" id="writer" v-model="writer" />
        </div>
        <div class="form-group">
          <label>제목:</label> <input type="text" class="form-control" id="title" v-model="title" />
        </div>

        <div class="form-group">
          <label>내용:</label> <input type="text" class="form-control" id="content" v-model="content" />
        </div>

        <div class="btn-group btn-center">
          <input type="button" class="btn btn-primary" value="등록" id="btnInsert" @click="qnaInsert" />
        </div>
      </form>
    </div>
  </div>
</template>

<style>
.btn-center {
  text-align: center;
}

@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
