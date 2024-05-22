<script setup>
import { computed, ref, onMounted } from 'vue';
import { useStore } from 'vuex';
import DealList from "./components/DealList.vue";
import DealSearchBar from "./components/DealSearchBar.vue";
import Map from "./components/Map.vue";
import { searchByDong } from '../api/aptDeal.js';
import { selectAll ,insert, remove} from '../api/dealMark.js';

const store = useStore();
const user = computed(() => store.state.user);

const aptDealList = ref([]);
const aptMarkList = ref([]);

onMounted(() => {
  searchByDong(
    (response) => {
      console.log(response.data.length + "개의 아파트 거래 정보를 불러왔습니다.");
      aptDealList.value = response.data;
    },
    (error) => {
      console.error(error);
    }
  );

  selectAll(
    user.value.id,
    (response) => {
      console.log(response.data.length + "개의 찜 정보를 불러왔습니다.");
      aptMarkList.value = response.data;
    },(error) => {
      console.error(error);
    }
  )
  
});

function markSelected(aptDeal) {
  console.log("click selct");
  const mark = {
    userId: user.value.id,
    aptCode: aptDeal.aptCode
  }
  insert(mark,
  (response) => {
      console.log(response);
    },(error) => {
      console.error(error);
    }
  )
}

function unMarkSelected(aptDeal) {
  console.log("click unselct");
  const mark = {
    userId: user.value.id,
    aptCode: aptDeal.aptCode
  }
  remove(mark,
  (response) => {
      console.log(response);
    },(error) => {
      console.error(error);
    }
  )
}

</script>
<template>

  <div class="py-4 container-fluid">
    
        <div class="row">
          <div class="col-lg-3 mb-lg ">
            <!-- line chart -->
            <DealList :aptDealList="aptDealList" :aptMarkList="aptMarkList"  @dealMark="markSelected" @dealUnMark="unMarkSelected" />

          </div>
          <div class="col-lg-9 map">
            <div class="col">
              <DealSearchBar/>
            <!-- <carousel /> -->
          <div class="py-3">
              <Map :aptMarkerList="aptDealList" />
          </div>
            </div>
          </div>
        </div>
  </div>
</template>
