import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
	//用于存储共享数据
	user:{}
  },
  getters: {
  },
  mutations: {
	  // 用于设置用户信息
	  setUser(state,user){
		  state.user = ueer
	  }
  },
  actions: {
  },
  modules: {
  }
})
