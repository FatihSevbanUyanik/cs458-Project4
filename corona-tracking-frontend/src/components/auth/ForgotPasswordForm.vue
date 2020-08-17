<template>
   <form>
      <v-btn class="px-0 mx-0 mb-3" text icon @click="goToSigIn()">
         <v-icon>mdi-arrow-left</v-icon>
      </v-btn>
      <div class="mx-2">
         <div class="font-weight-bold headline">Forgot Password</div>
         <div class="caption grey--text lighten-1--text">
            Please type your email address to reset password.
         </div>
         <v-text-field
            @blur="$v.email.$touch()"
            :error-messages="mailErrors"
            v-model="email"
            id="email"
            label="Email"
            class="mt-2"
         ></v-text-field>
         <v-btn
            id="resetPassword"
            class="font-weight-bold primary px-10 mt-2"
            width="100%"
            @click="sendResetPasswordEmail"
         >Send Password Reset Mail</v-btn>
      </div>
   </form>
</template>

<style scoped>
</style>

<script>
import { required, email } from "vuelidate/lib/validators";

export default {
   data() {
      return {
         email: ""
      };
   },
   validations: {
      email: {
         required,
         email
      }
   },
   computed: {
      mailErrors() {
         const errors = [];
         if (!this.$v.email.$dirty) return errors;
         !this.$v.email.required && errors.push("Email is required.");
         !this.$v.email.email && errors.push("Email must be valid.");
         return errors;
      }
   },
   methods: {
      goToSigIn() { this.$emit("goToSignIn") },
      sendResetPasswordEmail() {
         this.$v.$touch();
         if (this.mailErrors.length != 0) {
            return;
         }

         this.$store
            .dispatch("sendResetPasswordEmail", {
               email: this.email
            })
            .then(result => {
               console.log(result)
               this.$toastr.s("Password Reset Email successfully sent");
               this.$router.push({ name: "auth.resetPassword", query: { resetToken: result.resetToken } })
            })
            .catch(() => {
               this.$toastr.e("Password reset email could not be sent.");
            });
      }
   }
};
</script>