import {Router} from "express";

export const UserRoute = (): Router => {
  const userRouter = Router()

  userRouter.get('/', (req, res) => {
    res.status(200).send({});
  })

  return userRouter
}
