import axios from "@/utils/axios.common.js";

function searchByDong(params, success, fail) {
  console.log(params.dongName, params.year, params.month);
  axios
    .get(`/apt/dongSearch?dongName=${params.dongName}&year=${params.year}&month=${params.month}`)
    .then(success)
    .catch(fail);
}

function searchByAptCode(param, success, fail) {
  const aptCode = param.aptCode.value;
  const floor = param.floor.value;
  axios.get(`/apt/aptFloorSearch?aptCode=${aptCode}&floor=${floor}`).then(success).catch(fail);
}
export { searchByDong, searchByAptCode };
