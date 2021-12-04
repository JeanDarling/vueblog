<template>
    <div>
        <Header/>
        <div class="mblog">
            <h2>{{blog.title}}</h2>
            <el-link icon="el-icon-edit"  v-if="ownBlog">
                <router-link :to="{name: 'BlogAdd', params : {blogId: blog.id}}">
                    编辑
                </router-link>
                </el-link>
            <el-divider></el-divider>
            <div class="content markdown-body" v-html="blog.content"></div>
        </div>
    </div>
</template>

<script>
    import Header from '../components/Header'
    import "github-markdown-css/github-markdown-light.css"

    export default {
        name: "BlogDetail",
        components: {Header},
        data() {
            return {
                blog: {
                    id: "",
                    title: "",
                    content:"",
                },
                ownBlog: false,

            }
        },
        created() {
            const blogId = this.$route.params.blogId
            console.log("blog->id", blogId)
            if(blogId) {
                this.$axios.get("/blog/" + blogId).then(res=>{
                    const blog = res.data.data
                    console.log("blog->", blog)
                    this.blog.id = blog.id
                    // 对content进行渲染
                    var MarkdownIt = require("markdown-it")
                    var md = new MarkdownIt()
                    var result = md.render(blog.content)
                    this.blog.content = result


                    this.blog.title = blog.title

                    // 是否展示编辑
                    this.ownBlog = (blog.userId === this.$store.getters.getUser.id)

                })
            }

        }

    }
</script>

<style scoped>

    .mblog{
        box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04);
        width: 100%;
        height: 700px;
        padding: 20px 15px;
    }
</style>