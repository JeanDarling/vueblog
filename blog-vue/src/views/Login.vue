<template>
        <el-container>
            <el-header>
                <img class="mylogo" src="../assets/jean.jpg" alt="">
            </el-header>
            <el-main>
                <el-form ref="form" :model="form" :rules="rules" label-width="100px" class="demo-ruleForm">
                    <el-form-item label="同户名" prop="username">
                        <el-input v-model="form.username"></el-input>
                    </el-form-item>
                    <el-form-item label="密码"  prop="password">
                        <el-input type="password" v-model="form.password"></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="submitForm('form')">登录</el-button>
                        <el-button @click="resetForm('form')">重置</el-button>
                    </el-form-item>
                </el-form>
            </el-main>
        </el-container>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                form: {
                    username: 'jean',
                    password: '123',
                },
                rules: {
                    username: [
                        { required: true, message: '请输入用户名', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],
                    password: [
                        { required: true, message: '请输入密码', trigger: 'blur' },
                        { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
                    ],

                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this
                        // alert('submit!');
                        this.$axios.post("/login", this.form).then(res=>{
                            const token =res.headers['authorization']
                            const userInfo = res.data.data
                            console.log("jwt->", token)
                            _this.$store.commit("SET_TOKEN", token)
                            _this.$store.commit("SET_USERINFO", userInfo)
                            _this.$router.push("/blogs")
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>

<style scoped>
    .el-header, .el-footer {
        background-color: #474442;
        color: #333;
        text-align: center;
        line-height: 60px;
    }
    .mylogo {
        height:60px;
        width: 60px;
        margin-right: 50%;
    }
    .el-aside {
        background-color: #474442;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        /*background-color: #E9EEF3;*/
        color: #333;
        text-align: center;
        line-height: 160px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }
    .demo-ruleForm{
        max-width: 500px;
        margin: 0 auto;
    }
</style>