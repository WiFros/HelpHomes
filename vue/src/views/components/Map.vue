<script>
/* global kakao */
export default {
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      script.type = 'text/javascript';
      script.src = `//dapi.kakao.com/v2/maps/sdk.js?appkey=47c03223227ed48ea0a77bd2dec0c6cf`;
      script.onload = () => this.initMap();
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      const container = document.getElementById('map');
      const options = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심 좌표
        level: 3, // 지도의 확대 레벨
      };
      new kakao.maps.Map(container, options);
    },
  },
};
</script>

<template>
  <div id="map" class="rounded-map"></div>
</template>

<style scoped>
.rounded-map {
  width: 100%;
  height: 500px; /* 원하는 높이 값으로 조정 */
  border-radius: 20px;
  overflow: hidden;
}
</style>