<script setup>
import { ref, computed } from "vue";
import { useRouter } from "vue-router";
import { insert } from "@/api/qna";

import { useStore } from "vuex";

const store = useStore();

const user = computed(() => store.state.user);
const writer = ref("");
const title = ref("");
const content = ref("");
// const customers = ref([]) //전체 데이터 담을 배열

const router = useRouter(); //setup단계에서 찾아놓기

function qnaInsert() {
  const maskName =
    user.value.name.substring(0, 1) + "*" + user.value.name.substring(2);
  const new_qna = {
    writer: maskName,
    title: title.value,
    content: content.value,
    writerId: user.value.id,
  };

  insert(new_qna);

  alert("등록 되었습니다!");

  writer.value = "";
  title.value = "";
  content.value = "";

  //리스트 화면으로 넘어가기
  router.push({ path: "/qna" }); //script 방식으로 넘어가기
}
</script>

<template>
  <div class="mt-4 container-fluid">
    <div class="card">
      <div class="card-header py-3">
        <h3>Q&A 등록</h3>
      </div>

      <div class="card-body">
        <div class="form-group">
          <h5>제목:</h5>
          <input id="title" v-model="title" class="form-control" type="text" />
        </div>

        <div class="form-group">
          <h5>내용:</h5>
          <input
            id="content"
            v-model="content"
            class="form-control"
            style="height: 300px"
            type="text"
          />
        </div>

        <div class="btn-group btn-center">
          <input
            id="btnInsert"
            class="btn btn-primary"
            type="button"
            value="등록"
            @click="qnaInsert"
          />
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
