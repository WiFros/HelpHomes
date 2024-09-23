<template>
  <div class="bg-white border-radius-xl">
      <div class="row justify-content-center ">
        <div class="row col-md-12 mt-3">
          <div class="form-group col-md-3 m-0">
            <select class="form-select bg-secondary text-light" id="sido" v-model="selectedSido" @change="fetchGugunList">
              <option value="">시도선택</option>
              <option v-for="sido in sidoList" :key="sido" :value="sido">{{ sido }}</option>
            </select>
          </div>
          <div class="form-group col-md-3 m-0">
            <select class="form-select bg-secondary text-light" id="gugun" v-model="selectedGugun" @change="fetchDongList">
              <option value="">구군선택</option>
              <option v-for="gugun in gugunList" :key="gugun" :value="gugun">{{ gugun }}</option>
            </select>
          </div>
          <div class="form-group col-md-3 m-0">
            <select class="form-select bg-secondary text-light" id="dong" v-model="selectedDong">
              <option value="">동선택</option>
              <option v-for="dong in dongList" :key="dong" :value="dong">{{ dong }}</option>
            </select>
          </div>
            <div class="form-group col-md-3 m-0">
              <button type="button" id="list-btn" class="btn btn-outline-primary" @click ="clickDong">
                빠른검색
              </button>
            </div>
        </div>
    </div>
  </div>
</template>

  
  
<script setup>
import { ref, onMounted } from 'vue';
import { getSidoList, getGugunList, getDongList } from '@/api/dongCode';
const sidoList = ref([]);
const gugunList = ref([]);
const dongList = ref([]);
const selectedSido = ref('');
const selectedGugun = ref('');
const selectedDong = ref('');

const emits = defineEmits(['clickDong']);
onMounted(() => {
  fetchSidoList();
});
function fetchSidoList() {
  getSidoList(
    (data) => {
      sidoList.value = data;
    },
    (error) => {
      console.error('Failed to fetch sido list:', error);
    }
  );
}

function fetchGugunList() {
  getGugunList(
    selectedSido.value,
    (data) => {
      gugunList.value = data;
      dongList.value = []; // 구/군 선택 시 동 리스트 초기화
    },
    (error) => {
      console.error('Failed to fetch gugun list:', error);
    }
  );
}

function fetchDongList() {
  getDongList(
    selectedSido.value,
    selectedGugun.value,
    (data) => {
      dongList.value = data;
    },
    (error) => {
      console.error('Failed to fetch dong list:', error);
    }
  );
}
function clickDong() {
  const params = {
    sidoName: selectedSido.value,
    gugunName: selectedGugun.value,
    dongName: selectedDong.value
  };
  emits('clickDong',params);
}
</script>
  
  
  <style scoped>
  </style>