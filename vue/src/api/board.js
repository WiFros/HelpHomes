import axios from "@/utils/axios.common.js";

function selectAll(success, fail) {
    axios
        .get("/boards")
        .then(success)
        .catch(fail);
}
function selectOne(param, success, fail) {
    axios
        .get("/boards/" + param)
        .then(success)
        .catch(fail);
}
function insert(board, success, fail) {
    console.log("insert:", board);
    axios
        .post("/boards", board)
        .then(success)
        .catch(fail);
}
function update(board, success, fail) {
    axios
        .put("/boards", board)
        .then(success)
        .catch(fail);
}
function remove(board, success, fail) {
    axios
        .delete("/boards/" + board.num)
        .then(success)
        .catch(fail);
}
export { selectAll, selectOne, insert, update, remove };