import axios from "@/utils/axios.common.js";

function getSidoList(success, fail) {
    axios
    .get(`/apt/sido`)
    .then(response => success(response.data))
    .catch(fail);
}

function getGugunList(sido, success, fail) {
    axios
    .get(`/apt/gugun`, { params: { sido } })
    .then(response => success(response.data))
    .catch(fail);
}

function getDongList(sido, gugun, success, fail) {
    axios
    .get(`/apt/dong`, { params: { sido, gugun } })
    .then(response => success(response.data))
    .catch(fail);
}

export { getSidoList, getGugunList, getDongList };
