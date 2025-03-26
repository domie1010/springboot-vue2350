const base = {
    get() {
        return {
            url : "http://localhost:8080/seafood/",
            name: "seafood",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/seafood/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "海产品销售系统"
        } 
    }
}
export default base
