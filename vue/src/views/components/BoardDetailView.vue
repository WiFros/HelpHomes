<script setup>
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { selectOne,remove,update } from "@/api/board.js";
import { useToast } from "vue-toastification";
let num = ref("");
let name = ref("");
let pass = ref("");
let title = ref("");
let wdate = ref("");
let count = ref("");
let content = ref("");

const currentRoute = useRoute();//경로정보
const router = useRouter();//라우터 
const toast = useToast();//알림창

const key = currentRoute.params.num;//변경해서 사용할 값 아니므로 그냥 쓰자!

onMounted(()=>{
  console.log('mounted');
  getOne();
})

function getOne(){
  selectOne(
    key,
    ({data}) => {
      num.value = data.num;
      name.value = data.name;
      pass.value = data.pass;
      title.value = data.title;
      wdate.value = data.wdate;
      count.value = data.count;
      content.value = data.content;
    },
    (error) => {console.log(error);}
  )
}
function deletePost() {
  if (confirm("정말로 삭제하시겠습니까?")) {
    remove(
      key,
      () => {
        toast.success("삭제되었습니다.");
        router.push({ name: "BoardList" });
      },
      (error) => {
        console.log(error);
      }
    );
  }
}

//수정 구현
function goToUpdate() {
  router.push({ name: "BoardUpdate", params: { num: key } });
}
//목록으로 이동
function goToList() {
  router.push({ name: "BoardList" });
}

</script>

<template>
  <div class="container mt-4">
    <h2>게시물 상세보기</h2>
    <hr>
    <div class="row">
      <div class="col-md-8">
        <h3>{{ title }}</h3>
        <p class="text-muted">작성자: {{ name }} | 작성일: {{ wdate }} | 조회수: {{ count }}</p>
        <hr>
        <div v-html="content"></div>
      </div>
      <div class="col-md-4">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">게시물 정보</h5>
            <p class="card-text">게시물 번호: {{ num }}</p>
            <p class="card-text">작성자: {{ name }}</p>
            <p class="card-text">작성일: {{ wdate }}</p>
            <p class="card-text">조회수: {{ count }}</p>
          </div>
        </div>
        <div class="btn2 mt-3">
          <button class="btn btn-primary me-2" @click="goToUpdate">수정</button>
          <button class="btn btn-danger me-2" @click="deletePost">삭제</button>
          <button class="btn btn-secondary" @click="goToList">목록으로</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style>
.btn2 {
  text-align: center;
  margin: 10px;
}

@media (min-width: 1024px) {
  .about {
    min-height: 100vh;
    display: flex;
    align-items: center;
  }
}
</style>
