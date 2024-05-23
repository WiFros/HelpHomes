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
  <div class="mt-4 container-fluid">


      
  <div class="card">
      <div class="card-header py-3" >
        <h3>Q&A 등록</h3>
      </div>

      <div class="card-body">
        <div class="form-group">
          <h5>제목:</h5> <input type="text" class="form-control" id="title" v-model="title" />
        </div>

        <div class="form-group">
          <h5>내용:</h5> <input type="text" class="form-control" id="content" v-model="content" style=" height: 300px;" />
        </div>

        <div class="btn-group btn-center">
          <input type="button" class="btn btn-primary" value="등록" id="btnInsert" @click="qnaInsert" />
        </div>
        </div>
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
