<script setup>
import { onMounted, ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import { selectOne, remove, update } from "@/api/qna.js";
import QnABoard from "./components/QnABoard.vue";
import { useToast } from "vue-toastification";
const num = ref("");
const writer = ref("");
const count = ref("");
const wdate = ref("");
const title = ref("");
const content = ref("");

const currentRoute = useRoute();
const router = useRouter();
const toast = useToast();
// 파라미터 받기
const param = ref(currentRoute.params.num);

const key = param.value;
const isModify = ref(false);

onMounted(readOne);

function readOne() {
  selectOne(
    key,
    (response) => {
      const result = response.data.data;
      num.value = result.num;
      title.value = result.title;
      content.value = result.content;
      writer.value = result.writer;
      count.value = result.count;
      wdate.value = result.wdate;
    },
    (error) => {
      console.log(error);
    },
  );
}

function qnaDelete() {
  remove(
    key,
    (response) => {
      if (response.data.code === 200) {
        toast.success("삭제 완료!");
      } else {
        toast.error("오류 발생!");
      }

      router.push({ name: "Qna" });
    },
    (error) => {
      console.log(error);
    },
  );
}

function qnaUpdate() {
  const update_qna = {
    num: num.value,
    title: title.value,
    content: content.value,
  };

  update(
    update_qna,
    (response) => {
      if (response.data.code === 200) {
        toast.success("수정 완료!");
      } else {
        toast.error("오류 발생!");
      }

      router.push({ name: "Qna" });
    },
    (error) => {
      console.log(error);
    },
  );
}
function enableEditing() {
  isModify.value = !isModify.value;
  document.getElementById("title").readOnly = isModify.value;
  document.getElementById("content").readOnly = isModify.value;
  var updateButton = document.getElementById("btnUpdateComplete");
  if (isModify.value) {
    updateButton.style.display = "none"; // 수정중일 때 버튼 표시
  } else {
    updateButton.style.display = "inline-block"; // 수정중이 아닐 때 버튼 숨김
  }
}
</script>

<template>
  <div class="row mt-4 container-fluid">
    <div class="col-lg-7">
      <QnABoard />
    </div>

    <div class="col-lg-5">
      <div class="card mb-3">
        <div class="card-header pb-3">
          <h5>질문</h5>
        </div>

        <div class="col card-body pt-0">
          <div class="row">
            <div class="form-group col-lg-3">
              <input
                id="num"
                v-model="num"
                class="form-control"
                readonly
                type="text"
              />
            </div>

            <div class="form-group col-lg-3">
              <input
                id="writer"
                v-model="writer"
                class="form-control"
                readonly
                type="text"
              />
            </div>

            <div class="form-group col-lg-3">
              <input
                id="wdate"
                v-model="wdate"
                class="form-control"
                readonly
                type="text"
              />
            </div>

            <div class="form-group col-lg-3">
              <input
                id="count"
                v-model="count"
                class="form-control"
                readonly
                type="text"
              />
            </div>
          </div>

          <div class="form-group">
            <input
              id="title"
              v-model="title"
              class="form-control"
              readonly
              type="text"
            />
          </div>

          <div class="form-group">
            <textarea
              id="content"
              v-model="content"
              class="form-control"
              readonly
              style="height: 150px"
            ></textarea>
          </div>

          <div class="btn-group">
            <input
              id="btnDelete"
              class="btn btn-danger"
              type="button"
              value="삭제"
              @click="qnaDelete()"
            />
          </div>

          <div class="btn-group mx-3">
            <input
              id="btnUpdate"
              class="btn btn-primary"
              type="button"
              value="수정 하기"
              @click="enableEditing()"
            />
          </div>

          <div class="btn-group">
            <input
              id="btnUpdateComplete"
              class="btn btn-primary"
              style="display: none"
              type="button"
              value="수정 완료"
              @click="qnaUpdate()"
            />
          </div>
        </div>
      </div>

      <div class="card">
        <div class="card-header pb-3">
          <h5>답변</h5>
        </div>

        <div class="col card-body pt-0">
          <div class="row">
            <div class="form-group col-lg-3">
              <input
                id="num"
                v-model="num"
                class="form-control"
                readonly
                type="text"
              />
            </div>

            <div class="form-group col-lg-3">
              <input
                id="writer"
                v-model="writer"
                class="form-control"
                readonly
                type="text"
              />
            </div>

            <div class="form-group col-lg-3">
              <input
                id="wdate"
                v-model="wdate"
                class="form-control"
                readonly
                type="text"
              />
            </div>

            <div class="form-group col-lg-3">
              <input
                id="count"
                v-model="count"
                class="form-control"
                readonly
                type="text"
              />
            </div>
          </div>

          <div class="form-group">
            <textarea
              id="content"
              v-model="content"
              class="form-control"
              readonly
              style="height: 150px"
            ></textarea>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style></style>
