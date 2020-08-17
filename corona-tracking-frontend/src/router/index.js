import Vue from 'vue'
import VueRouter from 'vue-router'
Vue.use(VueRouter)

// auth
import Auth from '@/components/auth/Auth.vue'
import AuthSignIn from '@/components/auth/SignIn.vue'
import ResetPassword from '@/components/auth/ResetPassword.vue'

// track
import Track from '@/components/track/Track.vue'
import TrackIndex from '@/components/track/index.vue'
import TrackCreate from '@/components/track/create.vue'


const routes = [
  {
    path: "/auth",
    component: Auth,
    children: [{
        path: "signIn",
        name: "auth.signIn",
        component: AuthSignIn,
      },
      {
        path: "forgotPassword",
        name: "auth.forgotPassword",
        component: AuthSignIn,
      },
      {
        path: "signUp",
        name: "auth.signUp",
        component: AuthSignIn,
      },
      {
        path: "resetPassword",
        name: "auth.resetPassword",
        component: ResetPassword
      }
    ],
    meta: {
      requiresVisitor: true
    }
  },
  {
    path: "/track",
    component: Track,
    children: [{
        path: "create",
        name: "track.create",
        component: TrackCreate,
      },
      {
        path: "",
        name: "track.index",
        component: TrackIndex,
      }
    ],
    meta: {
      requiresAuth: true
    }
  }
]

const router = new VueRouter({
  routes
})

export default router
