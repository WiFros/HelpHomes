import axios from "@/utils/axios.common.js";

function selectAll(param, success, fail) {
  axios
    .get("/dealMark/" + param)
    .then(success)
    .catch(fail);
}

function insert(mark, success, fail) {
  console.log("insert:", mark);
  axios.post("/dealMark", mark).then(success).catch(fail);
}

function remove(mark, success, fail) {
  axios.post("/dealMark/delete", mark).then(success).catch(fail);
}
function getAptListByDongCode(dongCode){
  console.log("getAptListByDongCode:", dongCode);
  return axios.get(`/apt/by-dong`,{
    params: {
      dongCode
    }
  });
}
export { selectAll, insert, remove, getAptListByDongCode};
