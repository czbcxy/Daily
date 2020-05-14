import Vue from 'vue'
import Router from 'vue-router'
import AppMain from '../components/AppMain'
import login from '../components/HeaderPage/login'
import EditBlogo from '../components/HeaderPage/EditBlogo'


Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [{
    path: '/',
    name: 'AppMain',
    component: AppMain
  },
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/EditBlogo',
      name: 'EditBlogo',
      component: EditBlogo
    }
  ]
})
