import axios from "@/utils/axios.common.js";

function selectAll(success, fail) {
    axios
        .get("/qna")
        .then(success)
        .catch(fail);
}
function selectOne(param, success, fail) {
    axios
        .get("/qna/" + param)
        .then(success)
        .catch(fail);
}
function insert(board, success, fail) {
    console.log("insert:", board);
    axios
        .post("/qna", board)
        .then(success)
        .catch(fail);
}
function update(board, success, fail) {
    const num = board.num;
    axios
        .put("/qna/"+num, board)
        .then(success)
        .catch(fail);
}
function remove(param, success, fail) {
    axios
        .delete("/qna/" + param)
        .then(success)
        .catch(fail);
}

function search(param, success, fail) {
    const title = param.condition;
    const word = param.word;
    axios
        .get(`qna/search?condition=${title}&word=${word}`)
        .then(success)
        .catch(fail);
}
export { selectAll, selectOne, insert, update, remove ,search};
