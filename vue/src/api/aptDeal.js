import axios from "@/utils/axios.common.js";

function searchByDong(success, fail) {
  axios.get("/apt/dongSearch?dongName=정왕동&year=2019&month=07").then(success).catch(fail);
}

export { searchByDong };
