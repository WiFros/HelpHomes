<script>
// service에서 props 로 받아온 아파트 리스트를 출력

import { toRaw } from "vue";
/* global kakao */

export default {
  /////////////////////////////////////////////////
  // 지도만 출력했다 aptMarkerList를 받아올때, 마커 출력 
  props: {
    aptMarkerList: {
      type: Array,
      required: true
    }
  },
  watch: {
    aptMarkerList: {
      handler(newVal) {
        console.log("--- map으로 데이터 도착 ---");
        console.log("Apt Deal List Updated:", newVal.length);
        this.initMap();
      },
      deep: true
    }
  },
  // 지도만 출력했다 aptMarkerList를 받아올때, 마커 출력
  /////////////////////////////////////////////////

  data() {
    return {
      markers: [],
      infowindow: null,
    };
  },


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
        console.log("--- initmap ---");
        console.log("Apt Deal List Updated:", this.aptMarkerList.length);
      

      const container = document.getElementById('map');

      const options = {
        center: new kakao.maps.LatLng(37.499590490909185, 127.0263723554437), // 지도의 중심 좌표
        level: 3, // 지도의 확대 레벨
      };
      this.map = new kakao.maps.Map(container, options);


      //this.displayMarker(this.markerPositions2);

      if (this.aptMarkerList.length != 0) {
        console.log("아파트 존재!")
        console.log(this.aptMarkerList.length)
        const markerPositions = this.convertToLatLng(this.aptMarkerList);
        this.displayMarker(markerPositions);
      }

    },

    convertToLatLng(arr) {
      return arr.map((aptDeal) => [
        aptDeal.lat,
        aptDeal.lng,
      ]);
    },
    
    displayMarker(markerPositions) {
      if (this.markers.length > 0) {
        this.markers.forEach((marker) => marker.setMap(null));
      }

      const positions = markerPositions.map(
        (position) => new kakao.maps.LatLng(...position)
      );

      if (positions.length > 0) {
        this.markers = positions.map(
          (position) =>
            new kakao.maps.Marker({
              map: toRaw(this.map),
              position,
            })
        );

        const bounds = positions.reduce(
          (bounds, latlng) => bounds.extend(latlng),
          new kakao.maps.LatLngBounds()
        );

        toRaw(this.map).setBounds(bounds);
      }
    }
  },
};

// methods: {
//     initMap() {
//       const container = document.getElementById("map");
//       const options = {
//         center: new kakao.maps.LatLng(33.450701, 126.570667),
//         level: 5,
//       };

//       //지도 객체를 등록합니다.
//       //지도 객체는 반응형 관리 대상이 아니므로 initMap에서 선언합니다.
//       this.map = new kakao.maps.Map(container, options);
//     },
//     displayMarker(markerPositions) {
//       if (this.markers.length > 0) {
//         this.markers.forEach((marker) => marker.setMap(null));
//       }

//       const positions = markerPositions.map(
//         (position) => new kakao.maps.LatLng(...position)
//       );

//       if (positions.length > 0) {
//         this.markers = positions.map(
//           (position) =>
//             new kakao.maps.Marker({
//               map: toRaw(this.map),
//               position,
//             })
//         );

//         const bounds = positions.reduce(
//           (bounds, latlng) => bounds.extend(latlng),
//           new kakao.maps.LatLngBounds()
//         );

//         toRaw(this.map).setBounds(bounds);
//       }
//     },
//   },


</script>

<template>
  <div id="map" class="rounded-map"></div>
</template>

<style scoped>
.rounded-map {
  width: 100%;
  height: 630px; /* 원하는 높이 값으로 조정 */
  border-radius: 20px;
  overflow: hidden;
}
</style> 