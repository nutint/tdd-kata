import express from "express";
import request from 'supertest'
import {UserRoute} from './user-route'

describe('UsersControllenpm r', () => {
  const userController = UserRoute()
  const mockedApp = express()
  mockedApp.use('/users', userController);

  describe('POST /users', () => {
    it('should return 200', async () => {
      await request(mockedApp)
        .get('/users')
        .expect(200)
    })
  })
})
