<template>
    <div>
        <!--        头部-->
        <Header></Header>
        <!--        主体信息-->
        <div class="block">
            <el-timeline>

                <el-timeline-item :timestamp="blog.created" placement="top" v-for="blog in blogs">
                    <el-card>
                        <h4>
                            <router-link :to="{name: 'BlogDetail', params: {blogId: blog.id}}">
                                {{blog.title}}
                            </router-link>
                        </h4>
                        <p>{{blog.desription}}</p>
                    </el-card>
                </el-timeline-item>

                <el-pagination class="pagination"
                               background
                               layout="prev, pager, next"
                               :current-page="currentPage"
                               :page-size="pageSize"
                               :total="total"
                                @current-change=page>
                </el-pagination>
            </el-timeline>
        </div>
    </div>
</template>

<script>
    import Header from "../components/Header";

    export default {
        name: "Blogs",
        components: {Header},
        data() {
            return {
                blogs: {},
                currentPage: 1,
                total: 0,
                pageSize: 5
            }
        },
        methods: {
            page(currentPage) {
                this.$axios.get("/blogs?currentPage=" + currentPage).then(res => {
                    console.log("res->", res)
                    this.blogs = res.data.data.records
                    this.currentPage = res.data.data.current
                    this.total = res.data.data.total
                    this.pageSize = res.data.data.size
                })
            }
        },
        created() {
            this.page(1)
        }
    }
</script>

<style scoped>

    .pagination {
        margin: 0 auto;
        text-align: center;
    }
</style>