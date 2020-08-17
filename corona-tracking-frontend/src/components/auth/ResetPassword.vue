<template>
   <v-row no-gutters>
      <v-col class="pa-6" xl="6" offset-xl="3" lg="8" offset-lg="2" md="10" offset-md="1">
         <v-container class="grey lighten-5 mx-0 px-0">
            <v-card class="mx-auto mt-6 elevation-5 pa-6">
               <form class="mx-2">
                  <div>
                     <div class="font-weight-bold headline">
                        Please Type a New Password
                     </div>
                     <v-text-field
                        @blur="$v.password.$touch()"
                        :error-messages="passwordErrors"
                        v-model="password"
                        label="Password"
                        type="password"
                        class="mb-2"
                     ></v-text-field>
                  </div>
                  <v-btn
                     @click="resetPassword()"
                     class="font-weight-regular primary px-10"
                  >Reset Password</v-btn>
               </form>
            </v-card>
         </v-container>
      </v-col>
   </v-row>
</template>

<style scoped>
</style>

<script>
import { required } from "vuelidate/lib/validators";

export default {
   data() {
      return {
         password: "",
         resetToken: ""
      };
   },
   validations: {
      password: { required }
   },
   computed: {
      passwordErrors() {
         const errors = [];
         if (!this.$v.password.$dirty) return errors
         !this.$v.password.required && errors.push('Password is required.')
         return errors
      }
   },
   methods: {
      resetPassword() {
         this.$store
            .dispatch("resetPassword", {
               passwordToken: this.$route.query.resetToken,
               password: this.password
            })
            .then(() => {
               this.$router.push({ name: "auth.signIn" })
            })
            .catch(() => {
               this.$router.push({ name: "auth.signIn" })
            });
      }
   }
};
</script>