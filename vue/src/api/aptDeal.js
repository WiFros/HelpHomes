import axios from '@/utils/axios.common.js';

function searchByDong(success, fail) {
  axios
    .get('/apt/dongSearch?dongName=정왕동&year=2019&month=07')
    .then(success)
    .catch(fail);
}

function searchByAptCode(param, success, fail) {
  const aptCode = param.aptCode.value;
  const floor = param.floor.value;
  axios
    .get(`/apt/aptFloorSearch?aptCode=${aptCode}&floor=${floor}`)
    .then(success)
    .catch(fail);
}

function selectAllMarkApart(param, success, fail) {
  axios
    .get('/apt/markApartAll/' + param)
    .then(success)
    .catch(fail);
}

export { searchByDong, searchByAptCode, selectAllMarkApart };
