<template>
  <form class="mx-2">
    <div>
      <div class="font-weight-bold headline">Login</div>
      <v-text-field
        id="usernameOrEmail"
        @blur="$v.usernameOrEmail.$touch()"
        :error-messages="usernameOrEmailErrors"
        v-model="usernameOrEmail"
        label="Email/Username"
      ></v-text-field>
      <v-text-field
        id="password"
        @blur="$v.password.$touch()"
        :error-messages="passwordErrors"
        v-model="password"
        label="Password"
        type="password"
        class="mb-2"
      ></v-text-field>
    </div>
    <v-btn id="btnSignIn" @click="signIn" class="font-weight-bold primary px-10">Login</v-btn>
    <a id="forgotPassword" @click="goToForgotPassword()" style="color: grey" class="ml-2 caption nobr">Forgot Password?</a>
  </form>
</template>

<style scoped>
.nobr {
  white-space: nowrap;
}
</style>

<script>
import { required } from "vuelidate/lib/validators";

export default {
  data() {
    return {
      usernameOrEmail: "",
      password: ""
    };
  },
  validations: {
    usernameOrEmail: { required },
    password: { required }
  },
  computed: {
    usernameOrEmailErrors() {
      const errors = [];
      if (!this.$v.usernameOrEmail.$dirty) return errors;
      !this.$v.usernameOrEmail.required && errors.push("Email is required.");
      return errors;
    },
    passwordErrors() {
      const errors = [];
      if (!this.$v.password.$dirty) return errors;
      !this.$v.password.required && errors.push("Password is required.");
      return errors;
    }
  },
  methods: {
    goToForgotPassword() {
      this.$emit("forgotPassword");
    },
    signIn() {
      this.$v.$touch();
      if (
        this.usernameOrEmailErrors.length != 0 ||
        this.passwordErrors.length != 0
      ) {
        return;
      }

      this.$store
        .dispatch("signInUser", {
          usernameOrEmail: this.usernameOrEmail,
          password: this.password,
        })
        .then(() => {
          this.$toastr.s("Successfully Logged In")
          this.$router.push({ name: 'track.index' })
        })
        .catch(() => {
          this.$toastr.e("Login Error");
        });
    }
  }
};
</script>