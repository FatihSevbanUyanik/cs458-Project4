<template>
  <form class="mx-2">
    <div>
      <div class="font-weight-bold headline">Register</div>
      <v-text-field
        class="my-4"
        id="nameSurname"
        @blur="$v.nameSurname.$touch()"
        :error-messages="nameSurnameErrors"
        v-model="nameSurname"
        dense
        label="Name/Surname"
      ></v-text-field>
      <v-text-field
        class="my-4"
        id="username"
        @blur="$v.username.$touch()"
        :error-messages="usernameErrors"
        dense
        v-model="username"
        label="Username"
      ></v-text-field>
      <v-text-field
        class="my-4"
        id="email"
        @blur="$v.email.$touch()"
        :error-messages="emailErrors"
        dense
        v-model="email"
        label="Email"
      ></v-text-field>
      <v-text-field
        class="my-4"
        id="age"
        @blur="$v.age.$touch()"
        :error-messages="ageErrors"
        dense
        v-model="age"
        label="Age"
      ></v-text-field>
      <v-text-field
        id="password"
        class="my-4"
        @blur="$v.password.$touch()"
        :error-messages="passwordErrors"
        v-model="password"
        dense
        label="Password"
        type="password"
      ></v-text-field>
      <v-text-field
        id="passwordConfirm"
        dense
        @blur="$v.passwordConfirm.$touch()"
        :error-messages="passwordConfirmErrors"
        v-model="passwordConfirm"
        label="Password Confirm"
        type="password"
         class="mt-4 mb-2"
      ></v-text-field>
    </div>
    <v-btn id="btnSignUp" @click="signUp" class="font-weight-bold primary px-10">Register</v-btn>
  </form>
</template>

<style scoped>
.nobr {
  white-space: nowrap;
}
</style>

<script>
import { required,
         minLength,
         sameAs, 
         email } from "vuelidate/lib/validators";

export default {
  data() {
    return {
      passwordConfirm: '',
      nameSurname: '',
      password: '',
      username: '',
      email: '',
      age: ''
    };
  },
  validations: {
      passwordConfirm: { required, sameAsPassword: sameAs("password") },
      nameSurname: { required },
      password: { required, minLength: minLength(8) },
      username: { required },
      email: { required, email },
      age: { required }
  },
  computed: {
    nameSurnameErrors() {
      const errors = [];
      if (!this.$v.nameSurname.$dirty) return errors;
      !this.$v.nameSurname.required && errors.push("Name and Surname is required.");
      return errors;
    },
    usernameErrors() {
      const errors = [];
      if (!this.$v.username.$dirty) return errors;
      !this.$v.username.required && errors.push("Username is required.");
      return errors;
    },
    passwordErrors() {
      const errors = [];
      if (!this.$v.password.$dirty) return errors;
      !this.$v.password.required && errors.push("Password is required.");
      !this.$v.password.minLength && errors.push("Minnimium 8 characters are required.");
      !this.password === this.passwordConfirm && errors.push("Passwords do not match");
      return errors;
    },
    passwordConfirmErrors() {
      const errors = [];
      if (!this.$v.passwordConfirm.$dirty) return errors;
      !this.$v.passwordConfirm.required && errors.push("Password is required.");
      !this.$v.passwordConfirm.sameAsPassword && errors.push("Passwords d not match.");
      return errors;
    },
    emailErrors() {
      const errors = [];
      if (!this.$v.email.$dirty) return errors;
      !this.$v.email.required && errors.push("Email is required.");
      !this.$v.email.email && errors.push("Email needs to be valid.");
      return errors;
    },
    ageErrors() {
      const errors = [];
      if (!this.$v.age.$dirty) return errors;
      !this.$v.age.required && errors.push("Age is required.");
      return errors;
    }
  },
  methods: {
    goToSignIn() {
      this.$emit("goToSignIn");
    },
    signUp() {
      this.$v.$touch();
      if (this.$v.$anyErrors) { return; }

      this.$store
         .dispatch("signUpUser", {
            username: this.username,
            password: this.password,
            name: this.nameSurname,
            email: this.email,
            age: this.age
         })
         .then(() => {
            this.$toastr.s("Successfully Signed Up")
            this.goToSignIn()
         })
         .catch(() => {
            this.$toastr.e("Register Error");
         });
    }
  }
};
</script>