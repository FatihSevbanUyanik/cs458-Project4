<template>
    <v-row no-gutters>
        <v-col class="pa-6" xl="6" offset-xl="3" lg="8" offset-lg="2" md="10" offset-md="1">
            <v-container class="lighten-5 mx-0 px-0">
                <v-card class="mx-auto mt-6 elevation-5">
                    <v-row no-gutters>
                        <v-col class="pa-10" md="6">
                            <v-row md="12" no-gutters>
                                <v-col md="12">
                                    <transition name="slide" type="transition" mode="out-in">
                                        <component
                                            @goToSignIn="goToSignIn()"
                                            @forgotPassword="gotoForgotPassword()"
                                            @goToSignUp="goToSignUp()"
                                            :is="componentId"
                                        ></component>
                                    </transition>
                                </v-col>
                            </v-row>
                        </v-col>
                        <v-col class="border hidden-sm-and-down" md="6">
                            <img
                                src="https://friendlystock.com/wp-content/uploads/2020/04/7-scary-coronavirus-cartoon-clipart.jpg"
                                width="100%"
                                height="500px"
                            >
                        </v-col>
                    </v-row>
                </v-card>
            </v-container>
        </v-col>
    </v-row>
</template>

<script>
import ForgotPasswordForm from "@/components/auth/ForgotPasswordForm";
import SignInForm from "@/components/auth/SignInForm";
import SignUpForm from "@/components/auth/SignUpForm";

export default {
    created() {
        if (this.$router.currentRoute.name == "auth.signIn") {
            this.componentId = "SignInForm"
        } else if (this.$router.currentRoute.name == "auth.forgotPassword") {
            this.componentId = "ForgotPasswordForm"
        } else {
            this.componentId = "SignUpForm"
        }
    },
    data() {
        return {
            componentId: ""
        };
    },
    components: { ForgotPasswordForm, SignInForm, SignUpForm },
    methods: {
        gotoForgotPassword() {
            this.componentId = "ForgotPasswordForm";
        },
        goToSignIn() {
            this.componentId = "SignInForm";
        },
        goToSignUp() {
            this.componentId = "SignUpForm";
        }
    }
};
</script>

<style scoped>
.border {
    border-left: 1px solid  #BDBDBD
}

.slide-enter {
    opacity: 0;
}

.slide-enter-active {
    animation: slide-in 0.2s ease-out forwards;
    transition: opacity 0.2s;
    opacity: 1;
}

.slide-leave {
    opacity: 1;
}

.slide-leave-active {
    animation: slide-out 0.2s ease-out forwards;
    transition: opacity 0.2s;
    opacity: 0;
}

@keyframes slide-in {
    from {
        transform: translateX(20px);
    }
    to {
        transform: translateX(0px);
    }
}

@keyframes slide-out {
    from {
        transform: translateX(0px);
    }
    to {
        transform: translateX(20px);
    }
}
</style>