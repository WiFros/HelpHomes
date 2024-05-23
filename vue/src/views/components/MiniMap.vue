<template>
  <div id="map-container">
    <div id="map" class="rounded-map"></div>
    <a
      href="javascript:;"
      class="btn btn-sm btn-dark float-right mb-0 map-button"
      @click="handleButtonClick"
    >내 지역 검색</a>
  </div>
</template>

<script setup>
import { onMounted, reactive, computed, toRaw } from 'vue';
import { useStore } from 'vuex';
import { getAptListByDongCode } from '@/api/dealMark.js';

/* global kakao */

const store = useStore();
const user = computed(() => store.getters.getUser);

const state = reactive({
  markers: [],
  infowindow: null,
  map: null,
  aptList: [],
});

function initMap() {
  const container = document.getElementById('map');
  const options = {
    center: new kakao.maps.LatLng(37.499590490909185, 127.0263723554437),
    level: 3,
  };
  state.map = new kakao.maps.Map(container, options);

  if (state.aptList.length != 0) {
    const markerPositions = convertToLatLng(state.aptList);
    displayMarker(markerPositions);
  }
}

function convertToLatLng(arr) {
  return arr.map((aptDeal) => [aptDeal.lat, aptDeal.lng]);
}

function displayMarker(markerPositions) {
  if (state.markers.length > 0) {
    state.markers.forEach((marker) => marker.setMap(null));
  }

  const positions = markerPositions.map(
    (position) => new kakao.maps.LatLng(...position)
  );

  if (positions.length > 0) {
    state.markers = positions.map(
      (position) =>
        new kakao.maps.Marker({
          map: toRaw(state.map),
          position,
        })
    );

    const bounds = positions.reduce(
      (bounds, latlng) => bounds.extend(latlng),
      new kakao.maps.LatLngBounds()
    );

    toRaw(state.map).setBounds(bounds);
  }
}

function handleButtonClick() {
  const userDongCode = user.value.dongCode;

  getAptListByDongCode(userDongCode)
    .then(response => {
      console.log("Apt List:", response.data);
      state.aptList = response.data;
      const markerPositions = convertToLatLng(state.aptList);
      displayMarker(markerPositions);
    })
    .catch(error => {
      console.error("Error loading apartments:", error);
    });
}

onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=47c03223227ed48ea0a77bd2dec0c6cf`;
    script.onload = () => initMap();
    document.head.appendChild(script);
  }
});
</script>

<style scoped>
#map-container {
  position: relative;
  width: 100%;
  height: 630px;
}

#map {
  width: 100%;
  height: 100%;
  border-radius: 20px;
  overflow: hidden;
}

.map-button {
  position: absolute;
  top: 10px;
  right: 10px;
  z-index: 1000; /* 지도 위에 표시되도록 높은 z-index 설정 */
}
</style>
