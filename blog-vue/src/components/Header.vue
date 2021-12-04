<template>
    <div class="header">
        <h3>欢迎来到Jean的博客</h3>
        <Avatar icon="ios-person" style="width: 100px;height: 100px" :src="user.avatar"/>
        <div>{{user.username}}</div>
        <div class="maction">
            <span><el-link href="/blogs">主页</el-link></span>
            <el-divider direction="vertical"></el-divider>
            <span><el-link type="success" href="/blogs/add">发表文章</el-link></span>
            <el-divider direction="vertical"></el-divider>
            <span v-show="!hasLogin"><el-link type="primary" href="/login">登录</el-link></span>
            <span v-show="hasLogin"><el-link type="danger" @click="logout">退出</el-link></span>
        </div>

    </div>
</template>

<script>
    import logo_url from "../assets/logo.jpg";

    export default {
        name: "Header",
        data() {
            return {
                user :{
                    username: ' 请先登录',
                    avatar:logo_url
                },
                hasLogin : false
            }
        },
        methods:{
            logout: function () {
                const _this = this
                _this.$axios.get("/logout", {
                    headers:{
                        "Authorization": localStorage.getItem("token")
                    }
                }).then(res=>{
                    _this.$store.commit("REMOVE_USERINFO")
                    _this.$router.push("/login")
                })
            }
        },
        created() {
            if(this.$store.getters.getUser.username) {
                console.log("user->", this.$store.getters.getUser.username)
                this.user.username = this.$store.getters.getUser.username
                //this.user.avatar = this.$store.getters.getUser.avatar
                this.hasLogin = true
            }
        }
    }
</script>

<style scoped>
.header{
    max-width: 960px;
    margin: 0 auto;
    text-align: center;
}
    .maction{
        margin:10px 0;
    }
</style>